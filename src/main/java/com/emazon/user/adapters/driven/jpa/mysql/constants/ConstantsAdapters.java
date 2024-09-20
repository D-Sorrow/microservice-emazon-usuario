package com.emazon.user.adapters.driven.jpa.mysql.constants;

public class ConstantsAdapters {

    private ConstantsAdapters() {}

    public static final String RESPONSE_CODE_CREATE = "201";
    public static final String RESPONSE_CODE_INVALID = "400";
    public static final String RESPONSE_CODE_SERVER_ERROR = "500";
    public static final String DESCRIPTION_CREATE= "User successfully created";
    public static final String DESCRIPTION_INVALID= "Invalid request";
    public static final String DESCRIPTION_SERVER_ERROR= "Internal server error";
    public static final String SUMMARY_CREATE_USER= "add user to database";
    public static final String DESCRIPTION_SUMMARY_CREATE_USER= "This endpoint stores a user in the database.";
}
