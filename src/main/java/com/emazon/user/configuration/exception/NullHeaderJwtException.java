package com.emazon.user.configuration.exception;

public class NullHeaderJwtException extends RuntimeException {
    public NullHeaderJwtException(String message) {
        super(message);
    }
}
