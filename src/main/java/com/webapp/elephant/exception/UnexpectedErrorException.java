package com.webapp.elephant.exception;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
