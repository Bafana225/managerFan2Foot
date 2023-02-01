package com.memel.manager.exception;

public class JoueurNotFoundException extends RuntimeException {
    public JoueurNotFoundException(String message) {
        super(message);
    }
}