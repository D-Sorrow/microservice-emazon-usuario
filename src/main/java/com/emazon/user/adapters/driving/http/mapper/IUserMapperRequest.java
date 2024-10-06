package com.emazon.user.adapters.driving.http.mapper;


import com.emazon.user.adapters.driving.http.dto.UserRequest;
import com.emazon.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static com.emazon.user.adapters.driving.http.contants.ControllerConstants.CONSTANT_ROL;
import static com.emazon.user.adapters.driving.http.contants.ControllerConstants.TARGET_ROL;

@Mapper(componentModel = "spring")
public interface IUserMapperRequest {

    User toUser(UserRequest user);

    UserRequest toRequestUser(User user);
    List<User> toUsers(List<User> users);
}
