package com.emazon.user.adapters.driving.http.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUser {

    @NotNull
    @NotBlank
    private Long userId;

    @NotNull
    @NotBlank
    private Long identityDocument;

    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    @NotBlank
    private String userLastName;

    @NotNull
    @NotBlank
    private String userPhoneNumber;

    @NotNull
    @NotBlank
    private Date dateOfBirth;

    @NotNull
    @NotBlank
    private String userEmail;

    @NotNull
    @NotBlank
    private String userPassword;
}
