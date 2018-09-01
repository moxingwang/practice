# websocket
* spring boot websocket stomp
* tomcat websocket


# case
* 集群
> 暂定发布订阅(redis)。

* 参数
> 建立连接的时候传参数。

* 通知

* 超时

# 重点
* 断开连接靠得是心跳检测

# 常见问题
* nginx转发或者域名访问握手失败
> 这种情况下，需要在代理端开启ws支持

        # enables WS support
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection  "upgrade";

# reference
* [spring websocket docs](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#websocket)
* [Springboot-Websocket整合](https://cdn2.jianshu.io/p/03e25674ce21?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation)
* [WebSocket 结合 Nginx 实现域名及 WSS 协议访问](http://www.cnblogs.com/mafly/p/websocket.html)
* [spring websocket中 STOMP](https://my.oschina.net/u/1590027/blog/879629)