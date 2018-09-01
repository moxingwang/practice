package top.moxingwang.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


/**
 * @description:
 * @author: MoXingwang 2018-08-03 21:39
 **/
@Component
@ServerEndpoint(value = "/chatendpoint")
public class ChatEndpoint {
    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);

    private static Map<String, Session> sessionMap = new Hashtable<String, Session>();

    @OnOpen
    public void start(Session session) {
        System.out.println("Guest" + session.getId() + " join");
        sessionMap.put(session.getId(), session);
        broadcast("Guest" + session.getId() + " join.");
    }

    @OnMessage
    public void process(Session session, String message) {
        System.out.println(session.getId() + " say: " + message);
        broadcast("Guest" + session.getId() + " [say]: " + message);
    }


    @OnClose
    public void end(Session session) {
        System.out.println("Guest" + session.getId() + " out.");
        sessionMap.remove(session.getId());
        broadcast("Guest" + session.getId() + " out.");
    }

    @OnError
    public void error(Session session, java.lang.Throwable throwable) {
        System.err.println("Guest" + session.getId() + " error: " + throwable);
        end(session);
    }

    void broadcast(String message) {
        RemoteEndpoint.Basic remote = null;
        Set<Map.Entry<String, Session>> set = sessionMap.entrySet();
        for (Map.Entry<String, Session> i : set) {
            remote = i.getValue().getBasicRemote();
            try {
                remote.sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
