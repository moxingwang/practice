如何使MySQL数据库产生数据改变事件通知其它应用
-------------------------



### 安装
#### 安装Zookeeper, Kafka, and Kafka Connect

##### confluent方式安装
> 使用confluent非常方便，具体相关的介绍请看官网。

* 下载
[https://www.confluent.io/download/](https://www.confluent.io/download/)

* 安装
> 安装非常简单只需解压tar文件启动即可,组合安装查看[Manual Install using ZIP and TAR Archives](https://docs.confluent.io/current/installation/installing_cp/zip-tar.html)。
> 备用下载地址：[https://packages.confluent.io/archive/4.1/confluent-oss-4.1.2-2.11.zip](https://packages.confluent.io/archive/4.1/confluent-oss-4.1.2-2.11.zip)
```
tar -zxvf confluent-oss-4.1.2-2.11.tar.gz
```

```
mo:confluent-4.1.2 mo$ pwd
/Users/mo/runtime/confluentopensource/confluent-4.1.2
mo:confluent-4.1.2 mo$ ls -al
total 8
drwxr-xr-x   8 mo  staff   256  7 19 14:49 .
drwxr-xr-x   4 mo  staff   128  7 30 15:05 ..
-rw-r--r--   1 mo  staff   871  7 19 14:49 README
drwxr-xr-x  57 mo  staff  1824  7 19 14:48 bin
drwxr-xr-x  14 mo  staff   448  7 19 14:26 etc
drwxr-xr-x   3 mo  staff    96  7 19 14:26 lib
drwxr-xr-x   6 mo  staff   192  7 19 14:26 share
drwxr-xr-x   9 mo  staff   288  7 19 14:49 src
```

* 启动

在当前目录下启动conlfuent。
```
./bin/confluent start
```


##### Debezium插件安装
下载后解压文件，
1. 安装插件Debezium
> 把解压后的debezium复制到conlfuent安装目录share/java文件中，如
```
/Users/mo/runtime/confluent-4.1.2/share/java/debezium-connector-mysql
```

2. 启动
```
./bin/confluent stop
./bin/confluent start
```

3. 测试
* http://localhost:9021


## 构建一个kafka connect
> 同样可以在页面上操作

```

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/  -d '{"name":"mysql-connector","config": {          "connector.class": "io.debezium.connector.mysql.MySqlConnector",         "database.hostname": "localhost",       "database.port": "3306",          "database.user": "root",      "database.password": "debezium",         "database.server.id": "41",     "database.server.name": "dbserver1",     "database.history.kafka.bootstrap.servers": "localhost:9092",     "database.history.kafka.topic": "dbhistory.inventory" ,     "include.schema.changes": "true" }}'

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/  -d '{"name":"mysql-connector","config": {          "connector.class": "io.debezium.connector.mysql.MySqlConnector",         "database.hostname": "192.168.10.133",       "database.port": "3306",          "database.user": "root",      "database.password": "Password@123",         "database.server.id": "42",     "database.server.name": "demo",     "database.history.kafka.bootstrap.servers": "localhost:9092",     "database.history.kafka.topic": "dbhistory.demo" ,     "include.schema.changes": "true" }}'

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/  -d '{"name":"mysql-connector-local","config": {          "connector.class": "io.debezium.connector.mysql.MySqlConnector",         "database.hostname": "192.168.226.126",       "database.port": "3306",          "database.user": "root",      "database.password": "password",         "database.server.id": "43",     "database.server.name": "tx_order",     "database.history.kafka.bootstrap.servers": "localhost:9092",     "database.history.kafka.topic": "tx_order.history.tx_order" ,     "include.schema.changes": "true" }}'

```

## docker mysql

    docker run -it --rm --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=debezium -e MYSQL_USER=mysqluser -e MYSQL_PASSWORD=mysqlpw debezium/example-mysql:0.8


## kafka发布订阅
```
./bin/kafka-console-producer --broker-list localhost:9092 --topic "tt.tt.tb_tt"
./bin/kafka-console-consumer --from-beginning --zookeeper localhost:2181 --topic "dbserver1.inventory.orders"
```

## 查看消息
```
./bin/kafka-avro-console-consumer --bootstrap-server localhost:9092 --property schema.registry.url=http://localhost:8081 --topic demo.inventory.products
```

## 组件
* kafka connect
* confluent schema-registry

## 客户端消费者

### 测试
* [发送消息](http://localhost:8080/send/32233)


# 常见问题
* 序列化
如果你使用debezium把数据同步到了kafka，自己去消费这些topic，在消费的时候需要使用avro来反序列化。具体原因是由于debezium采用avro的方式来序列化，具体参考[Serializing Debezium events with Avro](https://debezium.io/blog/2016/09/19/Serializing-Debezium-events-with-Avro/)。

* 启动失败
> 如故你现在的是最新版本，请查看的你解压后的文件夹名称是否带'\\'，去掉后就能够正常启动。

# 参考
* [Streaming Data from MySQL into Kafka with Kafka Connect and Debezium](https://rmoff.net/2018/03/24/streaming-data-from-mysql-into-kafka-with-kafka-connect-and-debezium/)
* [修改linux系统的时间EDT为CST](https://blog.csdn.net/yjh314/article/details/51669238)
* [Java Code Examples for io.confluent.kafka.serializers.KafkaAvroDecoder](https://www.programcreek.com/java-api-examples/index.php?api=io.confluent.kafka.serializers.KafkaAvroDecoder)
* [Kafka消息序列化和反序列化（下）](https://blog.csdn.net/u013256816/article/details/78657995)
* [Version 5.0.0 Docs » Getting Started » Installation » clients > Maven repository for JARs](https://docs.confluent.io/current/installation/clients.html)
* [Kafka 中使用 Avro 序列化组件(三)：Confluent Schema Registry](https://www.jianshu.com/p/cd6f413d35b0)