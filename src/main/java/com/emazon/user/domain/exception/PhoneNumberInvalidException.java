package com.emazon.user.domain.exception;

public class PhoneNumberInvalidException extends RuntimeException {
    public PhoneNumberInvalidException(String message) {
        super(message);
    }
}
