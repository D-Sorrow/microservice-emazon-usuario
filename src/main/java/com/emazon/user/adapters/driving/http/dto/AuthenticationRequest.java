package com.emazon.user.adapters.driving.http.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NonNull
    @NotEmpty
    private String email;

    @NonNull
    @NotEmpty
    private String password;
}
