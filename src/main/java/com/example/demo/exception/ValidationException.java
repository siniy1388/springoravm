/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

/**
 *
 * @author oleg
 */
public class ValidationException extends Exception {

    private String message;

    public ValidationException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
