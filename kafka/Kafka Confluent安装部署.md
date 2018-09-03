> official [Confluent Platform Quick Start](https://docs.confluent.io/current/quickstart/index.html) ; [Manual Install using ZIP and TAR Archives](https://docs.confluent.io/current/installation/installing_cp/zip-tar.html)

confluent的安装部署相对比较简单，confluent为我们提供了Confluent Platform,我们即可以快速启动整个confluent平台，也可以单独启动想要的组件。接下来我们详细介绍如何操作。

## confluent platform下载
* 地址[https://www.confluent.io/download/](https://www.confluent.io/download/)
* 解压`tar -zxvf confluent-5.0.0-2.11.tar.gz`后可以看到文件列表。

		-rw-r--r--@  1 mo  staff   871  7 29 08:19 README
		drwxr-xr-x@ 68 mo  staff  2176  7 29 07:52 bin 		//Driver scripts for starting and stopping services
		drwxr-xr-x@ 23 mo  staff   736  7 29 07:52 etc 		//Configuration files
		drwxr-xr-x@  3 mo  staff    96  7 29 07:38 lib 		//Systemd services
		drwxr-xr-x   2 mo  staff    64  8  4 21:36 logs 	//Log files
		drwxr-xr-x@  7 mo  staff   224  7 29 07:52 share 	//Jars and licenses
		drwxr-xr-x@  9 mo  staff   288  7 29 08:19 src 		//Source files that require a platform-dependent build


首先看看如何快速启动confluent platform全家桶`ZooKeeper`,`Kafka`,`Schema Registry`,`Control Center`,`Kafka Connect`,`Kafka REST Proxy`,`KSQL`。

#### 快速启动platform
> confluent platform分两个版本`Confluent Enterprise`和`Confluent Open Source`，`Confluent Enterprise`拥有更多的组件，这里测试选择`Confluent Enterprise`启动，因为它里面包含了`Control Center`方便我们测试，直观的从浏览器上看到数据信息。

* 启动 (特别说明我们的命令执行目录都是在confluent目录下，如我的目录`/Users/mo/runtime/confluent-5.0.0.2`)
	```
	./bin/confluent start
	```

	看到如下信息，说明我们的confluent platform中的多个组件都启动成功。

		Starting zookeeper
		zookeeper is [UP]
		Starting kafka
		kafka is [UP]
		Starting schema-registry
		schema-registry is [UP]
		Starting kafka-rest
		kafka-rest is [UP]
		Starting connect
		connect is [UP]
		Starting ksql-server
		ksql-server is [UP]
		Starting control-center
		control-center is [UP]

* 访问测试
	通过使用`http://localhost:9021`来访问`Control Center`,如图。
	![](https://github.com/moxingwang/kafka/blob/master/resource/confluent-platform-control-center.png?raw=true)

#### 自定义启动

这里我们使用两台机器模拟集群`192.168.226.184`,`192.168.226.27`,'192.168.226.189'分别编排为`host1`,`host2`,`host3`。修改三台机器对应的hosts文件。分别添加如下配置

	0.0.0.0 localhost  host1
	192.168.226.184 localhost  host2
	192.168.226.189  localhost host3

	192.168.226.27  localhost host1
	0.0.0.0   localhost  host2
	192.168.226.189  localhost  host3

	192.168.226.27  localhost  host1
	192.168.226.189  localhost   host2
	0.0.0.0  localhost  host3


分别为每台机器创建`myid`文件,没个myid保存要给唯一的数字即可，我这里三个host分别指定为1，2，3。
```
sudo mkdir /var/lib/zookeeper
sudo vi /var/lib/zookeeper/myid
```

每台机器分别指定如下配置

###### zookeeper配置和启动
* ```vi etc/kafka/zookeeper.properties```添加如下配置

        tickTime=2000
        dataDir=/var/lib/zookeeper/
        clientPort=2181
        initLimit=5
        syncLimit=2
		server.1=host1:2888:3888
		server.2=host2:2888:3888
		server.3=host3:2888:3888
        autopurge.snapRetainCount=3
        autopurge.purgeInterval=24

* 启动
```
 ./bin/zookeeper-server-start etc/kafka/zookeeper.properties
```


###### kafka配置和启动
* 修改配置`vi etc/kafka/server.properties`

```
zookeeper.connect=host1:2181,host2:2181,host3:2181

```
* 设置`broker.id=0`
	
	这里我们可以使用`broker.id.generation.enable=true`自动生成替代。
```
#broker.id=0
broker.id.generation.enable=true
advertised.listeners=PLAINTEXT://本机IP:9092
```

* 启动
```
./bin/kafka-server-start  etc/kafka/server.properties
```




###### Schema Registry配置和启动(可选)
* 配置`vi etc/schema-registry/schema-registry.properties`

	kafkastore.connection.url=host1:2181,host2:2181,host3:2181

* 启动
```
./bin/schema-registry-start etc/schema-registry/schema-registry.properties
```



###### kafka connect配置和启动
这里我们不使用官方模式的`avro`序列化方式，所有不启动组件`schema-registry`。

* 配置
	cp etc/schema-registry/connect-avro-distributed.properties  etc/schema-registry/connect-distributed.properties


* 修改`vi  etc/schema-registry/connect-distributed.properties`
	
	bootstrap.servers=host1:9092,host2:9092,host3:9092


```
	key.converter=org.apache.kafka.connect.json.JsonConverter
	#key.converter.schema.registry.url=http://192.168.226.184:8081
	value.converter=org.apache.kafka.connect.json.JsonConverter
	#value.converter.schema.registry.url=http://192.168.226.184:8081
```


* 启动
```
./bin/connect-distributed etc/schema-registry/connect-distributed.properties
```


###### Control Center配置和启动
* 配置`vi etc/confluent-control-center/control-center-dev.properties`

```
	bootstrap.servers=host1:9092,host2:9092,host3:9092
	zookeeper.connect=host1:2181,host2:2181:host3:2181
	#confluent.controlcenter.schema.registry.url=http://host1:8081,http://host2:8081,http://host3:8081
	confluent.controlcenter.connect.cluster=http://192.168.222.54:8083
```

* 启动
```
./bin/control-center-start etc/confluent-control-center/control-center-dev.properties 
```


> 到此为止kafka connect集群搭建成功。