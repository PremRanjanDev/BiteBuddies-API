package com.bitebuddies.controller;

import com.bitebuddies.dto.UserDto;
import com.bitebuddies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto loginUser) {
        return userService.login(loginUser);
    }

    @GetMapping("/all")
    public Collection<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
