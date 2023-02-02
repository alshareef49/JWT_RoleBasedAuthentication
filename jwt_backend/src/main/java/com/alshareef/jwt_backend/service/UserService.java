package com.alshareef.jwt_backend.service;

import com.alshareef.jwt_backend.entity.User;
import com.alshareef.jwt_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User registerNewUser(User user){
        return userRepository.save(user);
    }
}
