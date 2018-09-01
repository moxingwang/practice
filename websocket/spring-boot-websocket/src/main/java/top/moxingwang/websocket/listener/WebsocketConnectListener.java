package top.moxingwang.websocket.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * websocket连接监听
 *
 * @date 2018/4/26
 */
@Component
public class WebsocketConnectListener implements ApplicationListener<SessionConnectEvent> {

    private static final Logger log = LoggerFactory.getLogger(WebsocketConnectListener.class);


    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        log.info("建立连接:" + event.getMessage());
        //获取Session连接信息
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        //用户ID
        String userId = sha.getFirstNativeHeader("userId");
        String orderNo = sha.getFirstNativeHeader("orderNo");
        log.info("用户参数userId:{},orderNo:{}", userId, orderNo);
        //获取SessionId
        String sessionId = sha.getSessionId();
        log.info("SessionID is : {}", sessionId);

    }
}
