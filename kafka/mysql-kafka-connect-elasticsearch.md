> 前段时间写了[MySql实时数据变更事件捕获kafka confluent之debezium](https://github.com/m65536/practice/blob/master/kafka/MySql%E5%AE%9E%E6%97%B6%E6%95%B0%E6%8D%AE%E5%8F%98%E6%9B%B4%E4%BA%8B%E4%BB%B6%E6%8D%95%E8%8E%B7kafka%20confluent%E4%B9%8Bdebezium.md),使用的是confluent整套的，接下来这篇将会介绍笔者当前公司的实际实战。

> 首先明确我们的需求，公司订单数据越来越大，商户端和E端各种业务需求也越来越多查询越发复杂，我们想引进elasticsearch来实现查询和搜索。那么问题来了，实时更新的订单数据如何同步到es中，业务代码中insert或者update es中的index这肯定是不可取的，
