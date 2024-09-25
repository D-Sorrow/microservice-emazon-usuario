package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.api.IAuthenticationServicePort;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IAuthenticationValidPort;
import com.emazon.user.domain.spi.IJwtProvider;


public class AuthenticationUseCase implements IAuthenticationServicePort {

    public final IJwtProvider jwtProvider;
    public final IAuthenticationValidPort authenticationValidPort;

    public AuthenticationUseCase(IJwtProvider jwtProvider, IAuthenticationValidPort authenticationValidPort) {
        this.jwtProvider = jwtProvider;
        this.authenticationValidPort = authenticationValidPort;
    }
    @Override
    public String authenticate(String email, String password) {
        return jwtProvider.generateToken(authenticationValidPort.authenticate(email, password));
    }
}
