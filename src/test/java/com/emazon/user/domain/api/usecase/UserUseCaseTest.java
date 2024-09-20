package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IEncoderPort;
import com.emazon.user.domain.spi.IUserPersistencePort;
import com.emazon.user.provider.DataProviderUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IEncoderPort encoderPort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    void saveUser() {

        this.userUseCase.saveUser(DataProviderUser.getUser());

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(this.userPersistencePort).saveUser(userArgumentCaptor.capture());

        assertEquals(DataProviderUser.getUser().getUserId(), userArgumentCaptor.getValue().getUserId());
        assertEquals(DataProviderUser.getUser().getUserEmail(), userArgumentCaptor.getValue().getUserEmail());
        assertEquals(DataProviderUser.getUser().getUserName(), userArgumentCaptor.getValue().getUserName());
        assertEquals(DataProviderUser.getUser().getUserLastName(), userArgumentCaptor.getValue().getUserLastName());

    }
}