package com.emazon.user.adapters.driven.jpa.mysql.adapter;

import com.emazon.user.adapters.driven.jpa.mysql.mapper.IUserMapperEntity;
import com.emazon.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class AdapterUser implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserMapperEntity userMapperEntity;

    @Override
    public void saveUser(User user) {
        userRepository.save(userMapperEntity.toUserEntity(user));
    }
}
