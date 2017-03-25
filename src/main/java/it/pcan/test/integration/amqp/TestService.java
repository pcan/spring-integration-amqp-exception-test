/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import org.springframework.integration.annotation.ServiceActivator;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class TestService {
    
    @ServiceActivator
    public TestBean handleRequest(TestBean bean) {
        System.out.println("Received request: " + bean);
        if(bean.getId() < 0) {
            throw new MyRuntimeException("Error! id < 0");
        }
        
        return new TestBean(bean.getId() * 2);
    }
    
}
