package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

public interface IAuthenticationValidPort {

    public String authenticate(String email, String password);
}
