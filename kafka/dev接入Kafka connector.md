> confluent操作restful api文档[Kafka Connect REST Interface](https://docs.confluent.io/current/connect/references/restapi.html)

# 本地数据库测试
> 本地数据使用（配置好了binlog和表）
```
docker run -it --rm --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=debezium -e MYSQL_USER=mysqluser -e MYSQL_PASSWORD=mysqlpw debezium/example-mysql:0.8
```


### 添加connector test1
1 添加
```aidl
{
  "name": "inventory-connector",
  "config": {
    "connector.class": "io.debezium.connector.mysql.MySqlConnector",
    "tasks.max": "1",
    "database.hostname": "192.168.226.126",
    "database.port": "3306",
    "database.user": "root",
    "database.password": "debezium",
    "database.server.id": "184054",
    "database.server.name": "dbserver1",
    "database.whitelist": "inventory",
    "database.history.kafka.bootstrap.servers": "192.168.122.111:9092",
    "database.history.kafka.topic": "dbhistory.inventory"
  }
}
```
 
 2 kafka mq消费测试
    使用[kafka-consumer](https://github.com/m65536/practice/tree/master/kafka/kafka-consumer)项目测试，只需要修改application.properties文件和SpringBootKafkaConsumer启动测试即可。
    
* application.properties
 
```
spring.kafka.bootstrap-servers=192.168.122.111:9092
spring.kafka.consumer.group-id=trsdger
```
    
* SpringBootKafkaConsumer
只需要配置KafkaListener即可，例如
```aidl
    @KafkaListener(id = "t3143", topics = "dbserver3.inventory.customers")
    public void listenT3(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }
```
id可以随意制定，不重复即可，topics的构成方式为：[database.server.name].[数据库名].[表名]