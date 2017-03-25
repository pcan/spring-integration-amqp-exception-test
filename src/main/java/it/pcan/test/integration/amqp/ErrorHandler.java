/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import java.util.HashMap;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class ErrorHandler {

    @ServiceActivator
    public Message handleException(Message msg) {
        System.out.println("Exception thrown: " + msg);
        MessageHandlingException payload = (MessageHandlingException) msg.getPayload();
        MessageHeaders headers = payload.getFailedMessage().getHeaders();
        HashMap<String, Object> newHeaders = new HashMap<>(headers);
        
        newHeaders.putAll(msg.getHeaders());
        Throwable cause = payload.getCause();
        RuntimeException ex = (cause instanceof RuntimeException) ? (RuntimeException)cause : new RuntimeException(cause);
        
        Message m = new GenericMessage(new RuntimeExceptionHolder(ex), newHeaders);
        return m;
    }

}
