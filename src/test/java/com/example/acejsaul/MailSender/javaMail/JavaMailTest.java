package com.example.acejsaul.MailSender.javaMail;

import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;

class JavaMailTest {

    @Test
    void sendSimpleMessage() {
        JavaMail mailSender = new JavaMail();
        mailSender.sendSimpleMessage("pedrolucasbezerra3@gmail.com",
                "Teste Unitário MailSender",
                "Teste Unitário realizado com sucesso");
    }
}