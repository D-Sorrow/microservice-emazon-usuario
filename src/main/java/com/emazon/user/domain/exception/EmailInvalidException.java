package com.emazon.user.domain.exception;

public class EmailInvalidException extends RuntimeException {
    public EmailInvalidException(String message) {
        super(message);
    }
}
