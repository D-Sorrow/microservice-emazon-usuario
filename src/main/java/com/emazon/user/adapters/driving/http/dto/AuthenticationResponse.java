package com.emazon.user.adapters.driving.http.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuthenticationResponse {
    private String token;
}
