package com.mo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebSocket Controller
 *
 * @date 2018/4/22
 */
@RestController
public class WebSocketController {

    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);


    @RequestMapping(value = "/send/{sessionId}")
    public String send(@PathVariable(value = "sessionId") String sessionId) {
        log.info("sessionId : {}", sessionId);
        return "OK";
    }


    /**
     * 设置消息头
     *
     * @param sessionId
     * @return
     */


}
