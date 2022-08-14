package com.nash.bookworm.controller;

import com.nash.bookworm.dto.UserDto;
import com.nash.bookworm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void saveUser(@RequestBody UserDto userr) {
        userService.saveUser(userr);
    }
}
