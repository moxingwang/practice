package top.moxingwang.websocket.configuration;

import top.moxingwang.websocket.listener.WebSocketDisconnectListener;
import top.moxingwang.websocket.listener.WebsocketConnectListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.StompSubProtocolErrorHandler;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * websocket配置类
 *
 *
 * @date 2018/4/16
 */
@EnableScheduling
@Configuration
@EnableWebSocketMessageBroker
@ComponentScan("top.moxingwang.websocket")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

/*
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.setSendTimeLimit(15 * 1000).setSendBufferSizeLimit(512 * 1024);
    }
*/


    /**
     * 注册stomp的端点
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 允许使用socketJs方式访问，访问点为webSocketServer，允许跨域
        // 在网页上我们就可以通过这个链接
        // http://localhost:8080/webSocketServer
        // 来和服务器的WebSocket连接
        stompEndpointRegistry.addEndpoint("/test/websocket")
                .setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置信息代理
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 订阅Broker名称 new long[]{10000L, 10000L}
//        registry.enableSimpleBroker("/testBroker");
//        ThreadPoolTaskScheduler

        registry.enableSimpleBroker("/testBroker").setHeartbeatValue(new long[]{75000L, 75000L}).setTaskScheduler(new CustomerTaskScheduler());

/*            registry.enableSimpleBroker("/testBroker").setHeartbeatValue(new long[]{70000L, 70000L}).setTaskScheduler(new TaskScheduler() {
            @Override
            public ScheduledFuture<?> schedule(Runnable runnable, Trigger trigger) {
                return null;
            }

            @Override
            public ScheduledFuture<?> schedule(Runnable runnable, Date date) {
                return null;
            }

            @Override
            public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, Date date, long l) {
                return null;
            }

            @Override
            public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long l) {
                return null;
            }

            @Override
            public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, Date date, long l) {
                return null;
            }

            @Override
            public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long l) {
                return null;
            }
        });*/
        // 全局使用的消息前缀（客户端订阅路径上会体现出来）
//        registry.setApplicationDestinationPrefixes("/app");
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        registry.setUserDestinationPrefix("/test/topic");
    }

    /**
     * WebSocket 连接
     *
     * @return
     */
    @Bean
    public WebsocketConnectListener websocketConnectListener() {
        return new WebsocketConnectListener();
    }

    /**
     * WebSocket 断开连接
     *
     * @return
     */
    @Bean
    public WebSocketDisconnectListener webSocketDisconnectListener() {
        return new WebSocketDisconnectListener();
    }

    /**
     * Websocket Error处理
     *
     * @return
     */
    @Bean
    public StompSubProtocolErrorHandler webSocketHandler() {
        return new WebSocketErrorHandler();
    }


    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        //设置session自动关闭断开连接
//        container.setMaxSessionIdleTimeout(10000L);
//        container.setAsyncSendTimeout(720L);

        return container;
    }






}

