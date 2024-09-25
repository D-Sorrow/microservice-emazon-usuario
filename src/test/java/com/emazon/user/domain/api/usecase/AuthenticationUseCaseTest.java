package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IAuthenticationValidPort;
import com.emazon.user.domain.spi.IJwtProvider;
import com.emazon.user.provider.DataProviderAuthentication;
import com.emazon.user.provider.DataProviderUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthenticationUseCaseTest {

    @Mock
    private IJwtProvider jwtProvider;

    @Mock
    private IAuthenticationValidPort authenticationValidPort;

    @InjectMocks
    private AuthenticationUseCase authenticationUseCase;

    @Test
    void authenticate() {
        this.authenticationUseCase.authenticate(
                DataProviderAuthentication.getAuthenticationRequestMock().getEmail(),
                DataProviderAuthentication.getAuthenticationRequestMock().getPassword()
        );
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> passwordCaptor = ArgumentCaptor.forClass(String.class);

        verify(this.authenticationValidPort).authenticate(emailCaptor.capture(), passwordCaptor.capture());

        this.jwtProvider.generateToken(DataProviderUser.getUser());
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        //verify(jwtProvider, times(1)).generateToken(DataProviderUser.getUser());


    }
}