package com.cs4.clothes.service;


import com.cs4.clothes.model.Role;
import com.cs4.clothes.model.RoleName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
    List<Role> finfAll();
}
