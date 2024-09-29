package com.emazon.user.configuration;

import com.emazon.user.adapters.driven.jpa.mysql.adapter.AdapterUser;
import com.emazon.user.adapters.driven.jpa.mysql.adapter.EncoderProvider;
import com.emazon.user.adapters.driven.jpa.mysql.mapper.IUserMapperEntity;
import com.emazon.user.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.api.usecase.UserUseCase;
import com.emazon.user.domain.spi.IEncoderPort;
import com.emazon.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserMapperEntity userMapperEntity;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new AdapterUser(userRepository, userMapperEntity);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(),encoderPort());
    }

    @Bean
    public IEncoderPort encoderPort() {
        return new EncoderProvider(passwordEncoder);
    }




}
