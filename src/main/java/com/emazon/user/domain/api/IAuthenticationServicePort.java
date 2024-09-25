package com.emazon.user.domain.api;

public interface IAuthenticationServicePort {

    String authenticate(String email, String password);
}
