package com.alshareef.jwt_backend.service;

import com.alshareef.jwt_backend.entity.Role;
import com.alshareef.jwt_backend.entity.User;
import com.alshareef.jwt_backend.repository.RoleRepository;
import com.alshareef.jwt_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("admin");
        adminRole.setRoleDescription("admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("user");
        userRole.setRoleDescription("user role for newly created user");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
        user.setUserFirstName("Shareef");
        user.setUserLastName("Ali");
        user.setUserName("shareef49");
        user.setUserPassword(getEncodedPassword("shareef@123"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
