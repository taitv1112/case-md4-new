package com.cs4.clothes.service.email;

import com.cs4.clothes.model.EmailVerificationToken;


import java.util.Optional;

public interface iEmailVerificationTokenService {
    public void saveToken(EmailVerificationToken emailVerificationToken);
    public Optional<EmailVerificationToken> getToken(String token);
    public void verifyToken(String token);
}
