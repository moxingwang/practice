> official [Debezium](https://debezium.io/)，demo [https://github.com/moxingwang/kafka](https://github.com/moxingwang/kafka)

> 本文主要讲在kafka confluent的基础上如何使用debezium插件获取mysql binlog数据事件完成实时数据流，debezium是以插件的方式配合confluent使用。

如果你的后端应用数据存储使用的MySQL，项目中如果有这样的业务场景你会怎么做呢？

- 分库分表数据拆分和迁移
- 历史数据同步分析
- 异步处理
- 多个应用之间数据同步和共享
- 建立elasticsearch搜索

对于最简单最直接的做法就是修改原有应用的代码，在数据发生改变的同时通知下游系统，或者数据改变发送MQ，下游系统消费消息。这样的设计虽然看似简单，但是实现真的很麻烦，数据库表多、业务复杂，各种业务代码里面到处是增删改，这样的设计后期难以维护，也难以保证数据一致性和可靠性。

![](https://github.com/moxingwang/resource/blob/master/image/debezium_old_artic.png?raw=true)

试想有没有可靠的替代方案，无需代码侵入，当数据库发生改变的时候，这些改变都是一个一个的data change事件发布到相应的中间件，下游系统订阅消息，这个设计就不得不提大名鼎鼎的kafka confluent了。

![](https://github.com/moxingwang/resource/blob/master/image/debezium_kafka_connect_1.png?raw=true)

> Kafka connect是Confluent公司(当时开发出Apache Kafka的核心团队成员出来创立的新公司)开发的confluent platform的核心功能.大家都知道现在数据的ETL过程经常会选择kafka作为消息中间件应用在离线和实时的使用场景中,而kafka的数据上游和下游一直没有一个无缝衔接的pipeline来实现统一,比如会选择flume或者logstash采集数据到kafka,然后kafka又通过其他方式pull或者push数据到目标存储.而kafka connect旨在围绕kafka构建一个可伸缩的，可靠的数据流通道，通过kafka connect可以快速实现大量数据进出kafka从而和其他源数据源或者目标数据源进行交互构造一个低延迟的数据pipeline。具体官网文档[https://www.confluent.io/](https://www.confluent.io/).

虽然kafka confluent提供了`JDBC Connector`使用JDBC的方式去获取数据源，这种方式kafka connector追踪每个表中检索到的组继续记录，可以在下一次迭代或者崩溃的情况下寻找到正确的位置，这里存在几种实现模式，具体可以参考官网说明[JDBC Source Connector](https://docs.confluent.io/current/connect/connect-jdbc/docs/source_connector.html?_ga=2.234527774.129940869.1534840941-1720937463.1533732285)。但是我这里推荐使用debezium，这种方式基于MySQL binlog的特性，首先你需要了解什么是debezium。

debezium是一个开源的分布式CDC（变更数据捕获）系统，支持对接各种数据源，将上游已持久化的数据变更捕获后写入消息队列，其特性查看官网[How it works](https://debezium.io/docs/faq/)，类似的CDC系统还有`Canal`。

## debezium使用
#### 部署kafka confluent
> 如何部署kafka confluent这里不再描述，可以参考我的[Kafka Confluent安装部署](https://juejin.im/post/5b75483a518825613c02b14b)这篇文章。

#### 安装debezium插件
* 下载
> 官网地址[debezium](https://debezium.io/),下载连接[MySQL Connector plugin archive](https://repo1.maven.org/maven2/io/debezium/debezium-connector-mysql/0.8.1.Final/debezium-connector-mysql-0.8.1.Final-plugin.tar.gz)
* 安装插件Debezium
> 把解压后的debezium复制到conlfuent安装目录share/java文件中，如
```
/Users/mo/runtime/confluent-4.1.2/share/java/debezium-connector-mysql
```
* 再次启动confluent即可

## debezium使用
> 以下操作都在本地部署测试。

使用debezium之前必须先开启mysql得binlog，这里不再叙述，具体可以参考我的[Linux安装Java、Maven、Mysql、RabbitMQ](https://juejin.im/post/5b1de8335188257d367e6697)这篇；接下来构建一个kafka connect来使用debezium插件，confluent提供了restful api可快速创建kafka connect。

#### 创建kafka connect连接
```
curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/  -d '
{
  "name": "mysql-connector",
  "config": {
    "connector.class": "io.debezium.connector.mysql.MySqlConnector",
    "database.hostname": "localhost",
    "database.port": "3306",
    "database.user": "root",
    "database.password": "debezium",
    "database.server.id": "1",
    "database.server.name": "dbserver1",
    "database.history.kafka.bootstrap.servers": "localhost:9092",
    "database.history.kafka.topic": "dbhistory.inventory",
    "include.schema.changes": "true"
  }
}
'
```
`注意：`这里的脚本其实是一行，我为了方便查看展开了json。复制可用的脚本：

```
curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/  -d '{"name":"mysql-connector","config": {          "connector.class": "io.debezium.connector.mysql.MySqlConnector",         "database.hostname": "localhost",       "database.port": "3306",          "database.user": "root",      "database.password": "debezium",         "database.server.id": "1",     "database.server.name": "dbserver1",     "database.history.kafka.bootstrap.servers": "localhost:9092",     "database.history.kafka.topic": "dbhistory.inventory" ,     "include.schema.changes": "true" }}'
```

如下图，说明连接创建成功。

![](https://github.com/moxingwang/kafka/blob/master/resource/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180820194418.png?raw=true)

也可以通过``` curl -H "Accept:application/json" localhost:8083/ ```查看已创建成功的connect，如图。

![](https://github.com/moxingwang/kafka/blob/master/resource/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180820194425.png?raw=true)

#### 验证
debezium会读取MySQL binlog产生数据改变事件，将事件发送到kafka队列，最简单的验证办法就是监听这些队列（这些队列按照表名区分）具体参考代码请查看[https://github.com/moxingwang/kafka](https://github.com/moxingwang/kafka)。

这里我们观察数据库的`inventory.customers`表，监听`dbserver1.inventory.customers`队列。

首先将customers表id为1004的email字段内容update如图。
![](https://github.com/moxingwang/kafka/blob/master/resource/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180820195810.png?raw=true)
![](https://github.com/moxingwang/kafka/blob/master/resource/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180820195815.png?raw=true)

此时，应用消费者会立马收到一条消费消息。

```
2018-08-20 19:57:20.742  INFO 3447 --- [      t34-0-C-1] com.mo.debezium.SpringBootKafkaConsumer  : ConsumerRecord(
	topic = dbserver1.inventory.customers, partition = 0, offset = 4, CreateTime = 1534766239965, serialized key size = 7, serialized value size = 151, 
	headers = RecordHeaders(headers = [], isReadOnly = false), 
	key = {"id": 1004}, 
	value = {"before": {"id": 1004, "first_name": "Anne", "last_name": "Kretchmar", "email": "annek@noanswer.org"},
 	"after": {"id": 1004, "first_name": "Anne", "last_name": "Kretchmar", "email": "test@noanswer.org"},
  	"source": {"name": "dbserver1", "server_id": 223344, "ts_sec": 1534766241, "gtid": null, "file": "mysql-bin.000003", "pos": 364, "row": 0, "snapshot": null, "thread": 7, "db": "inventory", "table": "customers"},
   	"op": "u", "ts_ms": 1534766239592}
)
```

到此我们的debezium方案已介绍完毕，使用起来也是相对比较加单的。

## 常见问题
* 序列化
如果你使用debezium把数据同步到了kafka，自己去消费这些topic，在消费的时候需要使用avro来反序列化。具体原因是由于debezium采用avro的方式来序列化，具体参考[Serializing Debezium events with Avro](https://debezium.io/blog/2016/09/19/Serializing-Debezium-events-with-Avro/)。

* 启动失败
> 如故你现在的是最新版本，请查看的你解压后的文件夹名称是否带'\\'，去掉后就能够正常启动。

* {"error_code":409,"message":"Cannot complete request because of a conflicting operation (e.g. worker rebalance)"}
[Apache Kafka 分布式消息队列框架](https://yuzhouwan.com/posts/26002/)

* [Connection to node -1 could not be established. Broker may not be available
[Connection to node -1 could not be established. Broker may not be available.](https://www.jianshu.com/p/475d02c76ba7)

# 参考
* [Streaming Data from MySQL into Kafka with Kafka Connect and Debezium](https://rmoff.net/2018/03/24/streaming-data-from-mysql-into-kafka-with-kafka-connect-and-debezium/)
* [修改linux系统的时间EDT为CST](https://blog.csdn.net/yjh314/article/details/51669238)
* [Java Code Examples for io.confluent.kafka.serializers.KafkaAvroDecoder](https://www.programcreek.com/java-api-examples/index.php?api=io.confluent.kafka.serializers.KafkaAvroDecoder)
* [Kafka消息序列化和反序列化（下）](https://blog.csdn.net/u013256816/article/details/78657995)
* [Version 5.0.0 Docs » Getting Started » Installation » clients > Maven repository for JARs](https://docs.confluent.io/current/installation/clients.html)
* [Kafka 中使用 Avro 序列化组件(三)：Confluent Schema Registry](https://www.jianshu.com/p/cd6f413d35b0)
* [实时数据平台设计：技术选型与应用场景适配模式](http://dbaplus.cn/news-73-2164-1.html)
* [Kafka connect快速构建数据ETL通道](https://blog.csdn.net/cssdongl/article/details/77750482)



> 后期持续跟新。

###### 关键词
confluent, kafka, kafka connect, debezium, schemas-registry