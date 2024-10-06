package com.emazon.user.adapters.driving.http;

import com.emazon.user.adapters.driving.http.dto.UserRequest;
import com.emazon.user.adapters.driving.http.exception.RoleIsNotValid;
import com.emazon.user.adapters.driving.http.mapper.IUserMapperRequest;
import com.emazon.user.domain.api.IUserServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

import static com.emazon.user.adapters.driven.jpa.mysql.constants.ConstantsAdapters.*;
import static com.emazon.user.adapters.driving.http.contants.ControllerConstants.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {
    
    private final IUserServicePort userService;
    private final IUserMapperRequest userMapperRequest;
    private static final String ROLE_REGX = "AUX_BODEGA|CLIENT";
    private static final Pattern ROLE_PATTERN = Pattern.compile(ROLE_REGX);


    @Operation(summary = SUMMARY_CREATE_USER, description = DESCRIPTION_SUMMARY_CREATE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = RESPONSE_CODE_CREATE, description = DESCRIPTION_CREATE),
            @ApiResponse(responseCode = RESPONSE_CODE_INVALID, description = DESCRIPTION_INVALID, content = @Content),
            @ApiResponse(responseCode = RESPONSE_CODE_SERVER_ERROR, description = DESCRIPTION_SERVER_ERROR, content = @Content)
    })
    @PostMapping("/saveUser")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequest user){
        if (!ROLE_PATTERN.matcher(user.getRole()).matches()){
            throw new RoleIsNotValid();
        }
        userService.saveUser(userMapperRequest.toUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
