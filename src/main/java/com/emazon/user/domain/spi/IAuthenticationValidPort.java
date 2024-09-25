package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

public interface IAuthenticationValidPort {

    public User authenticate(String username, String password);
}
