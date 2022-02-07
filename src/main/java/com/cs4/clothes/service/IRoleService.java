package com.cs4.clothes.service;


import com.cs4.clothes.model.Role;
import com.cs4.clothes.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
