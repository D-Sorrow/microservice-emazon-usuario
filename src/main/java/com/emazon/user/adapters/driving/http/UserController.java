package com.emazon.user.adapters.driving.http;

import com.emazon.user.adapters.driving.http.dto.RequestUser;
import com.emazon.user.adapters.driving.http.mapper.IUserMapperRequest;
import com.emazon.user.domain.api.IUserServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.emazon.user.adapters.driven.jpa.mysql.constants.ConstantsAdapters.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {
    
    private final IUserServicePort userService;
    private final IUserMapperRequest userMapperRequest;

    @Operation(summary = SUMMARY_CREATE_USER, description = DESCRIPTION_SUMMARY_CREATE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = RESPONSE_CODE_CREATE, description = DESCRIPTION_CREATE),
            @ApiResponse(responseCode = RESPONSE_CODE_INVALID, description = DESCRIPTION_INVALID, content = @Content),
            @ApiResponse(responseCode = RESPONSE_CODE_SERVER_ERROR, description = DESCRIPTION_SERVER_ERROR, content = @Content)
    })

    @PostMapping("/saveUser")
    public ResponseEntity<Void> saveUser(@RequestBody RequestUser user){
        userService.saveUser(userMapperRequest.toUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
