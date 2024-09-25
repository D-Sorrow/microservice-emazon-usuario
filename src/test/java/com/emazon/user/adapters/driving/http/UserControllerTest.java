package com.emazon.user.adapters.driving.http;

import com.emazon.user.adapters.driving.http.dto.UserRequest;
import com.emazon.user.adapters.driving.http.mapper.IUserMapperRequest;
import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IUserMapperRequest mapperRequest;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void saveUser() throws Exception {

        User user = new User();

        when(mapperRequest.toUser(any(UserRequest.class))).thenReturn(user);
        doNothing().when(userServicePort).saveUser(user);

        String mapArticleJson = new ObjectMapper().writeValueAsString(user);

        MockHttpServletRequestBuilder requestBuilder = post("/auth/saveUser")
                .content(mapArticleJson)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }
}