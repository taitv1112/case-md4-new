package com.cs4.clothes.service.email;

public interface iSendEmailService {
    public void sendEmail(String to, String body, String topic);
}
