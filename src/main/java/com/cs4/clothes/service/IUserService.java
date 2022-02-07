package com.cs4.clothes.service;



import com.cs4.clothes.model.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
    void deleteById(Long id);
    Optional<Users> findById(Long id);
     String signUpUser(Users user);
        List<Users> findByEnabledIsFalse();
    //
        int enableUserByEmail(String email);

        int enableUser(Long id);

        int lockUser(String username);

        int unlockUser(String username);
    //
    //    List<User> findAll();
    //
    //    Optional<User> findByUsername(String username);
    //
    //    void deleteUser(Long id);
    //    Optional<User> findByid(Long id);
}
