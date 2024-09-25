package com.emazon.user.provider;

import com.emazon.user.adapters.driven.jpa.mysql.entity.RolEnum;
import com.emazon.user.domain.model.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataProviderUser {

    public static User getUser() {
        return new User(28L,
                123456789L,
                "John",
                "Doe",
                "+1234567890",
                Date.from(LocalDate.of(2001,02,22).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "john.doe@example.com",
                "password123",
                RolEnum.AUX_BODEGA);
    }
}
