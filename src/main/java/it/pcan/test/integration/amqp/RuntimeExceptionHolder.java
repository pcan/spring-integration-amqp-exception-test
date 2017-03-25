/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pcan.test.integration.amqp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

/**
 *
 * @author Pierantonio Cangianiello
 */
public class RuntimeExceptionHolder implements Serializable {

    private final RuntimeException exception;

    @JsonCreator
    public RuntimeExceptionHolder(@JsonProperty("exception") @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "__class__") RuntimeException exception) {
        this.exception = exception;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "__class__")
    public RuntimeException getException() {
        return exception;
    }

}
