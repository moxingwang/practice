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
    "database.server.id": "184058",
    "database.server.name": "dbserver3",
    "database.whitelist": "inventory",
    "database.history.kafka.bootstrap.servers": "192.168.122.111:9092",
    "database.history.kafka.topic": "dbhistory.inventory111"
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


### 添加connector test2
1 新增数据库
```aidl
DROP SCHEMA IF EXISTS tx_order;
CREATE SCHEMA IF NOT EXISTS tx_order;

use tx_order;

CREATE TABLE `tx_promotion_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `promotion_type` int(4) DEFAULT NULL COMMENT '促销类型',
  `promotion_id` varchar(50) DEFAULT NULL COMMENT '促销代码，由促销中心系统提供',
  `task_type` int(1) DEFAULT NULL COMMENT '类型 1 付费预定 2 买劵 3 拼团购',
  `prom_value` varchar(50) DEFAULT NULL COMMENT '值',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0 未执行 1成功',
  `execute_date` datetime DEFAULT NULL COMMENT '执行时间',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5212 DEFAULT CHARSET=utf8 COMMENT='外部job数据处理表';



show variables like '%log_bin%';
```


2 添加
```aidl
{
   "name": "trade_order-connector",
   "config": {
     "connector.class": "io.debezium.connector.mysql.MySqlConnector",
     "tasks.max": "1",
   "database.hostname": "192.168.226.126",
    "database.port": "3306",
    "database.user": "root",
    "database.password": "debezium",
     "database.server.id": "1901",
     "database.server.name": "tradeOrderServer",
     "database.whitelist": "tx_order",
     "include.schema.changes": "true",
     "snapshot.mode": "schema_only",
     "database.history.kafka.bootstrap.servers": "192.168.122.111:9092",
     "database.history.kafka.topic": "dbhistory.trade.tx_order"
   }
 }

```

3 测试如上



### 添加connector dev正式数据库
1 添加 ("table.whitelist": "tx_order", 指定使用哪些表)
```aidl
{
  "name": "order-center-connector",
  "config": {
    "connector.class": "io.debezium.connector.mysql.MySqlConnector",
    "tasks.max": "1",
    "database.hostname": "db201.dev.rs.com",
    "database.port": "3306",
    "database.user": "canal",
    "database.password": "canal",
    "database.server.id": "190061",
    "database.server.name": "tradeOrder",
    "database.whitelist": "tx_order",
    "include.schema.changes": "false",
    "snapshot.mode": "schema_only",
    "snapshot.locking.mode": "none",
    "database.history.kafka.bootstrap.servers": "192.168.122.111:9092",
    "database.history.kafka.topic": "dbhistory.trade.order",
    "decimal.handling.mode": "string",
    "database.history.store.only.monitored.tables.ddl":"true",
    "database.history.skip.unparseable.ddl":"true",
    "database.serverTimezone":"UTC"
  }
}
```

3 测试如上

## 常见问题
1 Unexpected exception while parsing statement alter table pay_cs_market_balance alter column  balance_amt set default 0 at line 1
> https://blog.csdn.net/lzufeng/article/details/81488524