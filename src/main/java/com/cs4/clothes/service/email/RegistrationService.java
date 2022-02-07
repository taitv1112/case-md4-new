package com.cs4.clothes.service.email;

import com.cs4.clothes.model.EmailVerificationToken;
import com.cs4.clothes.model.Users;
import com.cs4.clothes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService implements iRegistrationService{
    @Autowired
    private IUserService userService;
    @Autowired
    private iEmailVerificationTokenService emailVerificationTokenService;
    @Autowired
    private SendEmailService sendEmailService;

    @Override
    public String register(Users users) {
        String token = userService.signUpUser(users);
        String verificationLink = "http://localhost:8080/register/confirm?token=" + token;
        String emailTo = users.getEmail();
        String body = "Please verify your account by clicking this link " + verificationLink;
        String title = "Verify case4 account";
        sendEmailService.sendEmail(emailTo,body,title);
        return "registered";
    }

    public String confirmToken(String token){
        EmailVerificationToken verificationToken
                = emailVerificationTokenService.getToken(token)
                .orElseThrow(() ->new IllegalStateException("token not found"));
                                                ;
        if (verificationToken.getVerifiedAt() != null){
            throw new IllegalStateException("email confirmed already");
        }

        LocalDateTime expiredAt = verificationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }

        emailVerificationTokenService.verifyToken(token);

        userService.enableUserByEmail(verificationToken.getUser().getEmail());

        return "verified";
    }

}
