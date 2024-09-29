package com.emazon.user.configuration.security;

import com.emazon.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.emazon.user.configuration.exception.ErrorMapperUserAuthenticationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.emazon.user.configuration.constants.ConstConfig.*;

public class JwtAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UserEntity user;
        String email;
        String password;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
            email = user.getUserEmail();
            password = user.getUserPassword();
        }catch (Exception e) {
            throw new ErrorMapperUserAuthenticationException(e.getMessage());
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();

        String token = jwtUtil.generateToken(user);

        response.addHeader(GET_HEADER_TOKEN, GET_HEADER_TOKEN_PREFIX + token);

        Map<String,Object> httpResponse = new HashMap<>();
        httpResponse.put(TOKEN_NAME, token);

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
