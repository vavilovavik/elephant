package com.webapp.elephant.exception;

public class ObjectNotFoundException extends RuntimeException {
    private ErrorCode code;

    public ObjectNotFoundException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message, ErrorCode code) {
        super(message);
    }

    public ObjectNotFoundException() {};
}
