package com.alshareef.jwt_backend.controller;

import com.alshareef.jwt_backend.entity.User;
import com.alshareef.jwt_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping({"/registerNewUser"})
    public User registerNewUser( @RequestBody User user){
        return userService.registerNewUser(user);
    }
}
