package com.revature.pokebid.util.cutom_exceptions;

public class ResourceConflictException extends RuntimeException {
    public ResourceConflictException() {
        super();
    }

    public ResourceConflictException(String message) {
        super(message);
    }
}
