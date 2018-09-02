## 安装docker
> 官网下载安装

## 配置镜像加速器,以及加速器配置，私有仓库配置
[阿里云如何配置镜像加速器](https://cr.console.aliyun.com/?spm=5176.1971733.0.2.6c045aaadLFb4c#/accelerator)


## 常见命令
* service docker stop 关闭docker服务
* docker run -p 80:80 -d nginx 运行image 
* docker rmi [imageID] 删除本地image
* docker commit 保存改动为新的image
* docker exec -u 0 -it mycontainer bash 进入container 
* echo 'newpassword' |passwd root --stdin 修改密码

#### docker container 操作
* container docket stop [containerID] 停止container
* docker ps 查看正在运行的container
* docker ps -a 查看已经运行的所有的container
* docker rm [containerID] 删除已经结束的container
* docker start [containerID] 启动stop了的container

#### 主机和container之间的操作
* docker cp 在host和container之间copy文件


#### docker commit 自己的镜像
* docker commit c0d2e573fa30 registry.cn-hangzhou.aliyuncs.com/m65536/centos:1.0.1
* ducker push registry.cn-hangzhou.aliyuncs.com/m65536/centos:1.0.1


## MySql
[https://hub.docker.com/_/mysql/](https://hub.docker.com/_/mysql/)

* docker pull mysql:5.7
* mac: docker run --name some-mysql -v /Users/mo/data/mysql/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql:5.7
* win: docker run --name some-mysql -v C:\Users\xingw\data\mysql\datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql:5.7

* 开启binlog
```
docker run --name some-mysql -v  /var/lib/mysql::/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql:5.7 mysqld  --datadir=/var/lib/mysql   --server-id=1   --log-bin=/var/log/mysql/mysql-bin.log
```

## redis 
* 登陆其他redis服务
````aidl
docker run -it --rm --name redis-client1  docker.io/redis redis-cli -h sen201.dev.rs.com -p 6379
docker run -it --rm --name redis-client1  docker.io/redis redis-cli -h localhost -p 6379
````
* server
````aidl
docker run --rm --name redis_server -d -p 6379:6379 redis
````


## 提交操作
* [docker常用命令详解](http://blog.csdn.net/permike/article/details/51879578)
* commit ： docker commit containerID tagName(自定义)
````aidl
docker commit 125b3f761a3c    registry.cn-hangzhou.aliyuncs.com/m65536/centos
````
* tag : docker tag ImageID 仓库:版本
````aidl
docker tag e6070ed1fc77 registry.cn-hangzhou.aliyuncs.com/m65536/centos:latest
````
* push : docker push 仓库
````aidl
docker push registry.cn-hangzhou.aliyuncs.com/m65536/centos:latest
````

## 镜像
* [时速代](https://hub.tenxcloud.com/)


## 应用程序数据

## 配置网络
* [Docker网络模式](http://dockone.io/article/1261)


## 如何学习docker
#### 入门
* https://www.imooc.com/learn/867

## 参考书籍
* [Docker指南](https://yeasy.gitbooks.io/docker_practice/swarm/)
* [Docker — 从入门到实践](https://www.gitbook.com/book/yeasy/docker_practice/details)
* [10张图带你深入理解Docker容器和镜像](http://dockone.io/article/783)
* [理解Docker（2）：Docker 镜像](http://www.cnblogs.com/sammyliu/p/5877964.html)
* [全面了解Docker](https://github.com/moxingwang/Docker-introduce)
* [一分钟看懂Docker的网络模式和跨主机通信](http://www.cnblogs.com/yy-cxd/p/6553624.html)
* [ Docker学习笔记 — Weave实现跨主机容器互联](http://blog.csdn.net/wangtaoking1/article/details/45244525)
* [docker常用命令详解](http://blog.csdn.net/permike/article/details/51879578)
* [docker常用命令详解](http://blog.csdn.net/permike/article/details/51879578)
* [Docker 清理命令集锦](https://www.jb51.net/article/56051.htm)

## 镜像位置
* mac: /Users/MyUserName/Library/Containers/com.docker.docker/Data/com.docker.driver.amd64
* windows: C:\Users\Public\Documents\Hyper-V