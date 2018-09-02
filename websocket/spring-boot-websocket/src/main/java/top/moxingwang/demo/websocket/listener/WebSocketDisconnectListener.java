package top.moxingwang.demo.websocket.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Websocket断开连接监听器
 *
 * @date 2018/4/26
 */
@Component
public class WebSocketDisconnectListener implements ApplicationListener<SessionDisconnectEvent> {

    private static final Logger log = LoggerFactory.getLogger(WebSocketDisconnectListener.class);


    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        log.info("断开连接" + event.getMessage());
        //获取Session连接信息
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        //获取SessionId
        String sessionId = sha.getSessionId();
    }
}
