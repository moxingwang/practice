> 前段时间写了[MySql实时数据变更事件捕获kafka confluent之debezium](https://github.com/m65536/practice/blob/master/kafka/MySql%E5%AE%9E%E6%97%B6%E6%95%B0%E6%8D%AE%E5%8F%98%E6%9B%B4%E4%BA%8B%E4%BB%B6%E6%8D%95%E8%8E%B7kafka%20confluent%E4%B9%8Bdebezium.md),使用的是confluent整套的，接下来这篇将会介绍笔者当前公司的实际实战。

> 首先明确我们的需求，公司订单数据越来越大，商户端和E端各种业务需求也越来越多查询越发复杂，我们想引进elasticsearch来实现查询和搜索。那么问题来了，实时更新的订单数据如何同步到es中，业务代码中insert或者update es中的index这肯定是不可取的，我们选择使用kafka和debezium结合使用，读取MySQLbinlog及时写入es。


## 安装
#### MySQL
  MySQL的安装比较简单，同时需要MySQL开启binlog，为了简单我这里使用docker启动一个MySQL并且里面已创建有数据。
  
* docker 
```aidl
docker run -it --rm --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=debezium debezium/example-mysql:0.8
```

  如果本地没有docker环境或者MySQL环境可以参考[mysql 5.7 主从同步配置（windows）](https://blog.csdn.net/natahew/article/details/71122569)和[MySQL 5.7.18 数据库主从（Master/Slave）同步安装与配置详解](https://www.jishux.com/plus/view-641331-1.html)配置。
  
  这里给出同上docker的数据库和表结构。
```aidl

```
