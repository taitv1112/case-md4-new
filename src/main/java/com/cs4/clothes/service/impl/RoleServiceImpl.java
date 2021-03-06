package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Role;
import com.cs4.clothes.model.RoleName;
import com.cs4.clothes.repository.IRoleRepository;
import com.cs4.clothes.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
