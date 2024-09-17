package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

public interface IUserPersistencePort {

    public void saveUser(User user);
}
