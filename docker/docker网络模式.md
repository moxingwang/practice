Docker 四种网络模式：
bridge方式(默认)、none方式、host方式、container复用方式

1、bridge方式： –net=”bridge”

容器与Host网络是连通的： 
eth0实际上是veth pair的一端，另一端（vethb689485）连在docker0网桥上 
通过Iptables实现容器内访问外部网络

2、none方式： –-net=”none” 
这样创建出来的容器完全没有网络，将网络创建的责任完全交给用户。可以实现更加灵活复杂的网络。 
另外这种容器可以可以通过link容器实现通信。

3、host方式： -–net=”host” 
容器和主机公用网络资源，使用宿主机的IP和端口 
这种方式是不安全的。如果在隔离良好的环境中（比如租户的虚拟机中）使用这种方式，问题不大。

4、container复用方式： -–net=”container:name or id” 
新创建的容器和已经存在的一个容器共享一个IP网络资源



