package com.emazon.user.adapters.driving.http.dto;

import com.emazon.user.adapters.driving.http.contants.ControllerConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static com.emazon.user.adapters.driving.http.contants.ControllerConstants.NOT_NULL_USER_ID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUser {

    @NotNull(message = NOT_NULL_USER_ID)
    private Long userId;

    @NotNull(message = ControllerConstants.NOT_NULL_IDENTITY_DOCUMENT)
    private Long identityDocument;

    @NotNull(message = ControllerConstants.NOT_NULL_USER_NAME)
    @NotBlank(message = ControllerConstants.NOT_BLANK_USER_NAME)
    private String userName;

    @NotNull(message = ControllerConstants.NOT_NULL_USER_LAST_NAME)
    @NotBlank(message = ControllerConstants.NOT_BLANK_USER_LAST_NAME)
    private String userLastName;

    @NotNull(message = ControllerConstants.NOT_NULL_PHONE_NUMBER)
    @NotBlank(message = ControllerConstants.NOT_BLANK_PHONE_NUMBER)
    private String userPhoneNumber;

    @NotNull(message = ControllerConstants.NOT_NULL_DATE_OF_BIRTH)
    private LocalDate dateOfBirth;

    @NotNull(message = ControllerConstants.NOT_NULL_EMAIL)
    @NotBlank(message = ControllerConstants.NOT_BLANK_EMAIL)
    private String userEmail;

    @NotNull(message = ControllerConstants.NOT_NULL_PASSWORD)
    @NotBlank(message = ControllerConstants.NOT_BLANK_PASSWORD)
    private String userPassword;
}
