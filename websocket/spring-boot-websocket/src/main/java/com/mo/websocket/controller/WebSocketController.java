package com.mo.websocket.controller;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Set;

/**
 * WebSocket Controller
 *
 *
 * @date 2018/4/22
 */
@RestController
public class WebSocketController {

    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);



    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @RequestMapping(value = "/send/{sessionId}")
    public String send(@PathVariable(value = "sessionId") String sessionId) {
        log.info("sessionId : {}", sessionId);
        simpMessagingTemplate.convertAndSendToUser(sessionId, "/testBroker",
                "当前时间为：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                createHeaders(sessionId));
        return "OK";
    }


    /**
     * 设置消息头
     *
     * @param sessionId
     * @return
     */

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }


}
