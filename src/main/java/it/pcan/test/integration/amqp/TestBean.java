/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import java.util.logging.Logger;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class TestBean {

    private int id;

    public TestBean() {
    }

    public TestBean(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestBean{" + "id=" + id + '}';
    }

}
