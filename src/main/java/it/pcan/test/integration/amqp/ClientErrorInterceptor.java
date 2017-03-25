/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

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
        return message;
    }

}
