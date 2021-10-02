package com.example.email;

import org.springframework.mail.MailException;

public interface MailService {

    void sendSimpleMail(String to, String subject, String content) throws MailException;
}
