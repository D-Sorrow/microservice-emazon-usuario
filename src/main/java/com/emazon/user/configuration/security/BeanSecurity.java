package com.emazon.user.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@RequiredArgsConstructor
public class BeanSecurity {

   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(encoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("Gabriel")
                .password("1234")
                .roles("ADMIN")
                .authorities("CREATE")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

}
