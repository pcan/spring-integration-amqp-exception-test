/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import org.springframework.integration.annotation.Gateway;

/**
 *
 * @author Pierantonio Cangianiello
 */
public interface ClientGateway {
    
    @Gateway
    public TestBean process(TestBean bean);
    
}
