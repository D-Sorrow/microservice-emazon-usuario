package com.emazon.user.adapters.driven.jpa.mysql.mapper;

import com.emazon.user.adapters.driven.jpa.mysql.entity.RolEnum;
import com.emazon.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.emazon.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapperEntity {
    UserEntity toUserEntity(User user);
}
