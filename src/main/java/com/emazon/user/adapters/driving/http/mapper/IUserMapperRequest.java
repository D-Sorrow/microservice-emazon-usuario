package com.emazon.user.adapters.driving.http.mapper;


import com.emazon.user.adapters.driving.http.dto.RequestUser;
import com.emazon.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapperRequest {

    @Mapping(target = "role", constant = "AUX_BODEGA")
    User toUser(RequestUser user);

    RequestUser toRequestUser(User user);
    List<User> toUsers(List<User> users);
}
