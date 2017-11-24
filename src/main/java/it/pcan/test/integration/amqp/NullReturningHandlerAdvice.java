package it.pcan.test.integration.amqp;

import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class NullReturningHandlerAdvice extends AbstractRequestHandlerAdvice {

    @Override
    protected Object doInvoke(ExecutionCallback ec, Object o, Message<?> msg) throws Exception {
        System.out.println("executing");
        Object result = ec.execute();
        return result == null ? new NullObject() : result;
    }

}
