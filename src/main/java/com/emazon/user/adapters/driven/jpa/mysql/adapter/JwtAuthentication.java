package com.emazon.user.adapters.driven.jpa.mysql.adapter;

import com.emazon.user.adapters.driven.jpa.mysql.mapper.IUserMapperEntity;
import com.emazon.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IAuthenticationValidPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RequiredArgsConstructor
public class JwtAuthentication implements IAuthenticationValidPort {

    private final AuthenticationManager authenticationManager;
    private final IUserMapperEntity userMapperEntity;
    private final IUserRepository userRepository;


    @Override
    public User authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        return userMapperEntity.toUserEntity(userRepository.findByUserEmail(email));
    }
}
