package com.emazon.user.adapters.driving.http.contants;

public class ControllerConstants {

    private ControllerConstants() {}

    public static final String TARGET_ROL = "role";
    public static final String CONSTANT_ROL = "AUX_BODEGA";

    public static final String NOT_NULL_USER_ID = "User ID cannot be null";
    public static final String NOT_NULL_IDENTITY_DOCUMENT = "Identity document cannot be null";

    public static final String NOT_NULL_USER_NAME = "User name cannot be null";
    public static final String NOT_BLANK_USER_NAME = "User name cannot be blank";
    public static final String NOT_NULL_USER_LAST_NAME = "User last name cannot be null";
    public static final String NOT_BLANK_USER_LAST_NAME = "User last name cannot be blank";

    public static final String NOT_NULL_PHONE_NUMBER = "Phone number cannot be null";
    public static final String NOT_BLANK_PHONE_NUMBER = "Phone number cannot be blank";
    public static final String INVALID_PHONE_NUMBER = "Invalid phone number format";

    public static final String NOT_NULL_DATE_OF_BIRTH = "Date of birth cannot be null";
    public static final String PAST_DATE_OF_BIRTH = "Date of birth must be in the past";

    public static final String NOT_NULL_EMAIL = "Email cannot be null";
    public static final String NOT_BLANK_EMAIL = "Email cannot be blank";
    public static final String INVALID_EMAIL = "Invalid email format";

    public static final String NOT_NULL_PASSWORD = "Password cannot be null";
    public static final String NOT_BLANK_PASSWORD = "Password cannot be blank";

    public static final String RESPONSE_CODE_CREATE = "201";
    public static final String RESPONSE_CODE_INVALID = "400";
    public static final String RESPONSE_CODE_SERVER_ERROR = "500";
    public static final String DESCRIPTION_CREATE= "User successfully created";
    public static final String DESCRIPTION_INVALID= "Invalid request";
    public static final String DESCRIPTION_SERVER_ERROR= "Internal server error";
    public static final String SUMMARY_CREATE_USER= "add user to database";
    public static final String DESCRIPTION_SUMMARY_CREATE_USER= "This endpoint stores a user in the database.";

    public static final String RESPONSE_CODE_200 = "200";
    public static final String RESPONSE_CODE_401 = "401";
    public static final String RESPONSE_CODE_500 = "500";

    public static final String DESCRIPTION_200 = "User authenticated successfully, JWT token generated";
    public static final String DESCRIPTION_401 = "Invalid credentials";
    public static final String DESCRIPTION_500 = "Internal server error";

    public static final String MEDIA_TYPE_JSON = "application/json";

    public static final String SUMMARY_USER_LOGIN = "User login";
    public static final String DESCRIPTION_SUMMARY_USER_LOGIN = "Authenticate a user with email and password, and generate a JWT token.";


}
