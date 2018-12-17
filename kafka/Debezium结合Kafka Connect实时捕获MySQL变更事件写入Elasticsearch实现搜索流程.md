> 前段时间写了[MySql实时数据变更事件捕获kafka confluent之debezium](https://github.com/m65536/practice/blob/master/kafka/MySql%E5%AE%9E%E6%97%B6%E6%95%B0%E6%8D%AE%E5%8F%98%E6%9B%B4%E4%BA%8B%E4%BB%B6%E6%8D%95%E8%8E%B7kafka%20confluent%E4%B9%8Bdebezium.md),使用的是confluent整套的，接下来这篇将会介绍完整实战。

> 首先明确需求，公司订单数据越来越大，商户端和E端各种业务需求也越来越多查询越发复杂，我们想引进elasticsearch来实现查询和搜索。那么问题来了，实时更新的订单数据如何同步到es中，业务代码中insert或者update es中的index这肯定是不可取的，我们选择使用kafka和debezium结合使用，读取MySQLbinlog及时写入es.

![](https://github.com/m65536/resource/blob/master/image/kafka/MySQL-kafka-connect-debezium-es-0.png?raw=true)

 本文将会实现一套完整的Debezium结合Kafka Connect实时捕获MySQL变更事件写入Elasticsearch并实现查询的流程.

## 安装
#### MySQL
  MySQL的安装比较简单，同时需要MySQL开启binlog，为了简单我这里使用docker启动一个MySQL并且里面已创建有数据。
  
* docker安装
```aidl
docker run -it --rm --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=debezium -e MYSQL_USER=mysqluser -e MYSQL_PASSWORD=mysqlpw debezium/example-mysql:0.8

```

* local安装
  如果本地没有docker环境或者MySQL环境可以参考[mysql 5.7 主从同步配置（windows）](https://blog.csdn.net/natahew/article/details/71122569)和[MySQL 5.7.18 数据库主从（Master/Slave）同步安装与配置详解](https://www.jishux.com/plus/view-641331-1.html)配置。
  
  这里给出同上docker的数据库和表结构，点击[msyql table inventory ddl](https://github.com/m65536/resource/blob/master/script/debezium/sql_ddl_0/inventory_ddl.sql)下载。

#### Zookeeper
  kafka的启动依赖于zookeeper,所以这里先安装并且启动zookeeper.
* [download](https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.10/)

* [install and start](https://zookeeper.apache.org/doc/r3.4.13/zookeeperStarted.html)
  
  首先需要配置`conf/zoo.cfg`,可以直接复制一份`conf/zoo_sample.cfg`使用.切换到安装目录下`bin/zkServer.sh start`启动zookeeper.

#### Kafka
* [kafka download](https://kafka.apache.org/downloads)
* [MySQL Connector plugin archive download](https://repo1.maven.org/maven2/io/debezium/debezium-connector-mysql/0.8.3.Final/debezium-connector-mysql-0.8.3.Final-plugin.tar.gz)

  下载好了的kafka文件目录里面其实默认已经包含了几个connect,这里我们需要使用的是`debezium`这个插件,所以需要把下载后的debezium安装到connect中,安装方法也比较简单,把解压后的`MySQL Connector plugin archive`里面的内容全部copy到kafka安装目录`libs`目录下即可.

* 启动kafka [Quickstart](https://kafka.apache.org/quickstart)

  在安装目录下执行`bin/kafka-server-start.sh config/server.properties`

* 启动kafka connect [Running Kafka Connect
](https://kafka.apache.org/documentation/#connect)

  在安装目录下执行`./bin/connect-distributed.sh config/connect-distributed.properties`

#### Elasticsearch
* [download](https://www.elastic.co/cn/downloads/elasticsearch)
* 启动,安装目录下 `bin/elasticsearch`

## 配置connect
  截止目前已经有了本地的`MySQL`,`kafka`,`kafka connect`,`elasticearch`,接下来配置kafka connect,通过配置好connect能够让debezium读取到binlog把MySQL的数据change事件写入到kafka的topic中.

  kafka connect为我们提供了restful的访问方式,详细文档查看[Kafka Connect REST Interface](https://docs.confluent.io/current/connect/references/restapi.html).

#### 新增一个connect

  put http://localhost:8083/connectors/order-center-connector/config
  ```
      {
    "connector.class": "io.debezium.connector.mysql.MySqlConnector",
    "tasks.max": "1",
    "database.hostname": "localhost",
    "database.port": "3306",
    "database.user": "root",
    "database.password": "debezium",
    "database.server.id": "1",
    "database.server.name": "trade_order_0",
    "database.whitelist": "inventory",
    "include.schema.changes": "false",
    "snapshot.mode": "schema_only",
    "snapshot.locking.mode": "none",
    "database.history.kafka.bootstrap.servers": "localhost:9092",
    "database.history.kafka.topic": "dbhistory.tradeOrder1",
    "decimal.handling.mode": "string",
    "database.history.store.only.monitored.tables.ddl":"true",
    "database.history.skip.unparseable.ddl":"true"
  }
  ```
![](https://github.com/m65536/resource/blob/master/image/kafka/local_update_insert_config_debezium_0.png?raw=true)

备注: `http://localhost:8083/connectors/order-center-connector/config`这个接口不但能更新connector还能创建,如果connector不存在的时候使它就会创建一个connector如果存在就去更新.

debezium提供了诸多配置参数,上图例子中只是提供了常用的配置,详细配置参考[Debezium Connector for MySQL
](https://debezium.io/docs/connectors/mysql/).

connector创建成功之后,可以通过[http://localhost:8083/connectors/](http://localhost:8083/connectors/)查看已经创建个的connector.

![](https://github.com/m65536/resource/blob/master/image/kafka/local_connector_0.png?raw=true)

同时你还可以通过[http://localhost:8083/connectors/order-center-connector/](http://localhost:8083/connectors/order-center-connector/)查看某一个connector的详细配置信息.

![](https://github.com/m65536/resource/blob/master/image/kafka/local_connector_1.png?raw=true)

也可以通过[http://localhost:8083/connectors/order-center-connector/status](http://localhost:8083/connectors/order-center-connector/status)查看当前connector的详细状态,如果当前connector出现故障,也会在这里提示出来.

![](https://github.com/m65536/resource/blob/master/image/kafka/local_connector_2.png?raw=true)


connector创建成功后,接下来应该测试debezium是否开始工作了,MySQL发生insert或者update 的时候有没有写入kafka.

`[注意事项]`

  笔者在配置connector的过程中也遇到过了好多问题,一些比较重要的东西也记录下来了,如果你在使用过程中出现问题可以查看文末`常见问题`里面是否有同样的问题.

#### debezium kafka topic消费
  在上面的debezium配置中可以看到参数`database.server.name`,`database.whitelist`,debezium connector会处理MySQL的binlog后对应数据库不同的表将消息发送到不通的topic上,其中这些topic的构成方式为:[database.server.name].[数据库名称].[表名称],记下来按步骤操作.


* 1. 在kafka的安装目录下使用`bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic trade_order_0.inventory.orders`消费`trade_order_0.inventory.orders`这个topic.

* 2. 任意修改orders表的一行数据,然后回到第一步就可以观察到.

![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezium_3.png?raw=true)

  看到这样的结果说明debezium已经开始工作了.

#### spring boot消费kafka消息并且写入elasticsearch中
  
* Demo代码已经在[https://github.com/m65536/practice/tree/master/search/elasticsearch](https://github.com/m65536/practice/tree/master/search/elasticsearch)全部实现.下载后配合上面安装好了的环境可以直接启动运行(当前版本使用的6.5,如果需要使用2.X,es客户端配置略有不同).

* [Index Templates](https://www.elastic.co/guide/en/elasticsearch/reference/current/indices-templates.html#indices-templates)

  使用创建index之前可以创建index template,使用简单并且方便灵活.

* 创建template

  put http://localhost:9200/_template/{模板名称}
```
{
  "template": "trade-order-sales",
  "order": 0,
  "mappings": {
    "_default_": {
      "_source": {
        "enabled": true
      }
    },
    "type": {
      "properties":{"orderNumber":{"type":"text"},"quantity":{"type":"text"},"productId":{"type":"text"},"purchaser":{"type":"date"},"orderDate":{"type":"text"},"purchaserName":{"type":"text"},"createDate":{"type":"date"}}
      
     }
  }
}
```
![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezium_2.png?raw=true)

* 启动项目测试
  
  启动[SpringBootElasticsearchApplication](https://github.com/m65536/practice/blob/master/search/elasticsearch/src/main/java/top/moxingwang/elasticsearch/SpringBootElasticsearchApplication.java)后,更改orders表任意数据,此时我们看到日志,再去观察es,如图.

![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezium_4.png?raw=true)

![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezoim_5.png?raw=true)

  此时说明MySQL到connect到kafka再到server再到es整个流程通了,同时可以通过server去查询es[TestController](https://github.com/m65536/practice/blob/master/search/elasticsearch/src/main/java/top/moxingwang/elasticsearch/controller/TestController.java)-[http://localhost:8080/test/list](http://localhost:8080/test/list)

![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezium_6.png?raw=true)


## 常见问题
* Unexpected exception while parsing statement alter table pay_cs_market_balance alter column  balance_amt set default 0 at line 1
> https://blog.csdn.net/lzufeng/article/details/81488524


* 如果配置无效
> 1 检查表白名单
> 2 检查database.server.id是否重复
> 3 检查其他配置重复是否


* 如何分词(version 2.X)
> https://zhuanlan.zhihu.com/p/29183128
> http://esuc.dev.rs.com:9200/_analyze?pretty&analyzer=keyword &text=SO5046240000014238

* 消费者乱码
> 保持写入消费使用的同一个序列化方式.

* 数据库`date`,`datetime`,`timestamp`之类的字段,消费者收到少了8个小时或者多了8个小时
> 这个问题主要是由于时区的问题,建议阅读官网文档[Temporal values without time zone
](https://debezium.io/docs/connectors/mysql/)

![](https://github.com/m65536/resource/blob/master/image/kafka/local_debezium_7.png?raw=true)

`解决办法`

  建议数据都改成`timestamp`(携带了时区)类型然后再kafka消费的时候使用Date对象接收,转成Date对象时区就是本地的了,再写入es就是你想要的了.
  
  