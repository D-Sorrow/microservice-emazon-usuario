package com.emazon.user.domain.exception;

public class InvalidDocumentException extends RuntimeException {
    public InvalidDocumentException(String message) {
        super(message);
    }
}
