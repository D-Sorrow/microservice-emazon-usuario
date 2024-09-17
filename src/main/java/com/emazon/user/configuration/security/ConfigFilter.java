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
                        http.requestMatchers("/auth/**").permitAll();
                        http.requestMatchers("/auth/save").hasRole("ADMIN");
                        http.anyRequest().denyAll();
                    })
                    .build();
    }

}
