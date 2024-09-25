package com.emazon.user.adapters.driving.http;

import com.emazon.user.adapters.driving.http.contants.ControllerConstants;
import com.emazon.user.adapters.driving.http.dto.AuthenticationRequest;
import com.emazon.user.adapters.driving.http.dto.AuthenticationResponse;
import com.emazon.user.domain.api.IAuthenticationServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/authenticationUser")
@Tag(name = "Authentication", description = "Endpoints for user authentication")
public class AuthController {

    private final IAuthenticationServicePort authenticationService;


    /**
     * Authenticates a user and generates a JWT token.
     *
     * @param authenticationRequest the request containing the user's email and password
     * @return AuthenticationResponse containing the JWT token
     */
    @Operation(summary = ControllerConstants.SUMMARY_USER_LOGIN, description = ControllerConstants.DESCRIPTION_SUMMARY_USER_LOGIN)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ControllerConstants.RESPONSE_CODE_200, description = ControllerConstants.DESCRIPTION_200,
                    content = { @Content(mediaType = ControllerConstants.MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = AuthenticationResponse.class)) }),
            @ApiResponse(responseCode = ControllerConstants.RESPONSE_CODE_401, description = ControllerConstants.DESCRIPTION_401, content = @Content),
            @ApiResponse(responseCode = ControllerConstants.RESPONSE_CODE_500, description = ControllerConstants.DESCRIPTION_500, content = @Content)
    })
    @GetMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        String token = authenticationService.authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        return authenticationResponse;
    }
}
