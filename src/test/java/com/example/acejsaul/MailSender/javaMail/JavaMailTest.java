package com.example.acejsaul.MailSender.javaMail;

import org.junit.jupiter.api.Test;

class JavaMailTest {

    @Test
    void sendSimpleMessage() {
        JavaGmailSender mailSender = new JavaGmailSender();
        mailSender.sendSimpleMessage("pedrolucasbezerra3@gmail.com",
                "Teste Unitário MailSender",
                "Teste Unitário realizado com sucesso");
    }
}