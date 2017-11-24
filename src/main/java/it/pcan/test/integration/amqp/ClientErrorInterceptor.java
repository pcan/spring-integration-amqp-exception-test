/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.GenericMessage;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class ClientErrorInterceptor extends ChannelInterceptorAdapter {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        if (message.getPayload() instanceof RuntimeExceptionHolder) {
            RuntimeExceptionHolder holder = (RuntimeExceptionHolder) message.getPayload();
            throw holder.getException();
        }
        if (message.getPayload() instanceof NullObject) {
            /**
             * @see NullReturningHandlerAdvice
             */
            MessageHeaders headers = message.getHeaders();
            Map<String, Object> newHeaders = new HashMap<>(headers);
            newHeaders.put("replyChannel", "nullChannel");
            return new GenericMessage(message.getPayload(), newHeaders);
        }
        return message;
    }

}
