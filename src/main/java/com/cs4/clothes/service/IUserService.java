package com.cs4.clothes.service;



import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<Users> findAllUser(Pageable pageable);

    Users findByID(long id);
}
