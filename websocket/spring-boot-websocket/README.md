---
title: spring boot websocket
date: 2018-09-02
categories:
- websocket
tags: websocket
---

一提到`websocket`我们会想到`http`,`长连接`,`推送`等等这些关键词，在项目中真实应用也比较广泛，比如网页聊天、消息推送、网页通知等等。本人也是最近项目中需要（POS机扫码付款成功后回调通知web页面收款通知），然后记录下来实现过程。项目采用前后端分离，前端`react`后端`spring-boot`。


# case
* 集群：暂定发布订阅
* 参数
* 通知
* 超时


# reference
* [spring websocket docs](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#websocket)
* [Springboot-Websocket整合](https://cdn2.jianshu.io/p/03e25674ce21?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation)
* [WebSocket 结合 Nginx 实现域名及 WSS 协议访问](http://www.cnblogs.com/mafly/p/websocket.html)
* [spring websocket中 STOMP](https://my.oschina.net/u/1590027/blog/879629)