package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

import java.security.Key;

public interface IJwtProvider {

    public String generateToken(User user);

    public boolean validateToken(String token);

    public Key SignatureKey();
}
