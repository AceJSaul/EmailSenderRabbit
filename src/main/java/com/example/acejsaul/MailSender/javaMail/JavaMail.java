package com.example.acejsaul.MailSender.javaMail;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Properties;

@Component
public class JavaMail {

    private final JavaMailSender mailSender;

    private final String mailSenderEmail = System.getenv("mailSender");
    private final String mailTestPassword = System.getenv("MAIL_SEND_PASSWORD");

    public JavaMail() {
        mailSender = getJavaMailSender();
    }

    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(mailSenderEmail);
        mailSender.setPassword(mailTestPassword);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.user", mailSenderEmail);
        properties.put("mail.smtp.password", mailTestPassword);

        return mailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSenderEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);


        mailSender.send(message);
    }

    public String getMailSenderEmail() {
        return mailSenderEmail;
    }

    public String getMailTestPassword() {
        return mailTestPassword;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }
}
