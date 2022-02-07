package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.EmailVerificationToken;
import com.cs4.clothes.model.Users;
import com.cs4.clothes.repository.IUserRepository;
import com.cs4.clothes.service.IUserService;
import com.cs4.clothes.service.email.EmailVerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailVerificationTokenService emailVerificationTokenService;

    @Override
    public Optional<Users> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public String signUpUser(Users user){
        boolean emailExisted = userRepository.findByEmail(user.getEmail()).isPresent();
        if (emailExisted){
            throw new IllegalStateException("email taken");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        EmailVerificationToken emailVerificationToken= new EmailVerificationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        emailVerificationTokenService.saveToken(emailVerificationToken);

        return token;
    }
    @Override
    public List<Users> findByEnabledIsFalse() {
        return userRepository.findAllByEnabledIsFalse();
    }

    @Override
    public int enableUserByEmail(String email){
        return userRepository.enableUserByEmail(email);
    }

    @Override
    public int enableUser(Long id) {
        return userRepository.enableUser(id);
    }

    @Override
    public int lockUser(String username){
        return userRepository.lockUser(username);
    }

    @Override
    public int unlockUser(String username) {
        return userRepository.unlockUser(username);
    }
}
