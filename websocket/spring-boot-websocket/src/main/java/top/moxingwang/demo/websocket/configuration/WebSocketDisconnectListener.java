package top.moxingwang.demo.websocket.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Websocket断开连接监听器
 */
public class WebSocketDisconnectListener implements ApplicationListener<SessionDisconnectEvent> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketDisconnectListener.class);


    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        logger.info("websocket连接断开" + event.getMessage());


    }
}
