package com.emazon.user.configuration.constants;


public class ConstConfig {

    private ConstConfig() {}

    public static final String DIRECTION_CONTROLLER_SAVE_USER_ROLE = "/auth/saveUser";
    public static final String DIRECTION_CONTROLLER_SAVE_USER_HAS_ROLE_ADMIN = "ADMIN";

    public static final String MESSAGE_AGE_INVALID_EXCEPTION = "The user must be over 18 years old.";
    public static final String MESSAGE_EMAIL_INVALID_EXCEPTION = "The email format is invalid.";
    public static final String MESSAGE_DOCUMENT_INVALID_EXCEPTION = "The identity document must contain only numeric characters.";
    public static final String MESSAGE_PHONE_INVALID_EXCEPTION = "The phone number format is invalid. It must contain between 1 and 13 digits, and can start with a '+'.";
    public static final String MESSAGE_NULL_HEADER_JWT_EXCEPTION = "The JWT header must not be null.";
    public static final String MESSAGE_ERROR_MAPPER_USER = "Error mapper request to user";

    public static final String GET_HEADER_TOKEN = "Authorization";
    public static final String GET_HEADER_TOKEN_PREFIX = "Bearer ";
    public static final int INDEX_TO_ELIMINATED_BEARER = 7;
    public static final String TOKEN_NAME = "token";
    public static final String USER_EMAIL_CLAIM_NAME = "userEmail";
    public static final String USER_ROL_CLAIM = "role";

}
