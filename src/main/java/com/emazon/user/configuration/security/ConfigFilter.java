package com.emazon.user.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static com.emazon.user.configuration.constants.ConstConfig.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                    .csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(http -> {
                        http.requestMatchers("/authenticationUser/login").permitAll();

                        http.requestMatchers(DIRECTION_CONTROLLER_SAVE_USER_ROLE)
                                .hasRole(DIRECTION_CONTROLLER_SAVE_USER_HAS_ROLE_ADMIN);

                        http.anyRequest().permitAll();
                    })
                    .build();
    }

}
