package com.emazon.user.provider;

import com.emazon.user.adapters.driving.http.dto.AuthenticationRequest;

public class DataProviderAuthentication {

    public static AuthenticationRequest getAuthenticationRequestMock() {
        return new AuthenticationRequest(
                "Gedubuc@example.com",
                "securePassword123"
        );
    }
}
