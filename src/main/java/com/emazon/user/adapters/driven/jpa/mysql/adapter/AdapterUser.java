package com.emazon.user.adapters.driven.jpa.mysql.adapter;

import com.emazon.user.adapters.driven.jpa.mysql.mapper.IUserMapperEntity;
import com.emazon.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class AdapterUser implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserMapperEntity userMapperEntity;

    @Override
    public void saveUser(User user) {
        String passEncoder = new BCryptPasswordEncoder().encode(user.getUserPassword());
        user.setUserPassword(passEncoder);
        userRepository.save(userMapperEntity.toUserEntity(user));
    }
}
