package com.alshareef.jwt_backend.service;

import com.alshareef.jwt_backend.entity.Role;
import com.alshareef.jwt_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }
}
