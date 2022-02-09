package com.cs4.clothes.repository;

import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
    List<Users> findAllByEnabledIsFalse();



    @Modifying
    @Query("UPDATE Users a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUserByEmail(String email);

    @Modifying
    @Query("UPDATE Users a SET a.enabled = TRUE WHERE a.id = ?1")
    int enableUser(Long id);

    @Modifying
    @Query("UPDATE Users a SET a.locked = TRUE WHERE a.username = ?1")
    int lockUser(String username);

    @Modifying
    @Query("UPDATE Users a SET a.locked = FALSE WHERE a.username = ?1")
    int unlockUser(String username);
}
