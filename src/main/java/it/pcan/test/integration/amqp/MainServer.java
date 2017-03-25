/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class MainServer {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/serverApplicationContext.xml")) {
            new Scanner(System.in).nextLine(); // Press Enter key to stop
            System.out.println("Done.");
        }
    }

}
