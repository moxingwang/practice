package top.moxingwang.demo.websocket.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.StompSubProtocolErrorHandler;

/**
 * WebSocket Error处理
 *
 * @author wxw
 * @date 2017-12-30 14:04
 */
public class WebSocketErrorHandler extends StompSubProtocolErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(WebSocketErrorHandler.class);

    public WebSocketErrorHandler() {
        super();
    }

    @Override
    public Message<byte[]> handleClientMessageProcessingError(Message<byte[]> clientMessage, Throwable ex) {
        log.error("handleClientMessageProcessingError:clientMessage-" + clientMessage + ", error-" + ex.getMessage());
        return super.handleClientMessageProcessingError(clientMessage, ex);
    }

    @Override
    public Message<byte[]> handleErrorMessageToClient(Message<byte[]> errorMessage) {
        log.error("handleErrorMessageToClient:errorMessage-" + errorMessage);
        return super.handleErrorMessageToClient(errorMessage);
    }

    @Override
    protected Message<byte[]> handleInternal(StompHeaderAccessor errorHeaderAccessor, byte[] errorPayload, Throwable cause, StompHeaderAccessor clientHeaderAccessor) {
        log.error("handleInternal:errorHeaderAccessor-" + errorHeaderAccessor + ", errorPayload-" + errorPayload + ", error-" + cause.getMessage() + ", clientHeaderAccessor-" + clientHeaderAccessor);
        return super.handleInternal(errorHeaderAccessor, errorPayload, cause, clientHeaderAccessor);
    }
}
