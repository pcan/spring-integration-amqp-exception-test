/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.core.MessagingTemplate;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class MainClient {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/clientApplicationContext.xml")) {

            ClientGateway gateway = context.getBean(ClientGateway.class);

            TestBean result = gateway.process(new TestBean(2));
            System.out.println("Result 1: " + result);

            try {
                result = gateway.process(new TestBean(-1));
                System.out.println("Result 2: " + result);
            } catch (Exception ex) {
                System.out.println("Exception received " + ex);
            }
            gateway.process2(new DummyBean());
            
            System.out.println("Done.");
        }
    }

}
