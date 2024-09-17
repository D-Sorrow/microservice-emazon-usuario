package com.emazon.user.adapters.driving.http;

import com.emazon.user.adapters.driving.http.dto.RequestUser;
import com.emazon.user.adapters.driving.http.mapper.IUserMapperRequest;
import com.emazon.user.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {
    
    private final IUserServicePort userService;
    private final IUserMapperRequest userMapperRequest;

    @GetMapping("/save")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Void> saveUser(@RequestBody RequestUser user){

        userService.saveUser(userMapperRequest.toUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
