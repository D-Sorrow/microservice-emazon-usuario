package com.emazon.user.domain.api;

import com.emazon.user.domain.model.User;

public interface IUserServicePort {

    public void saveUser(User user);
}
