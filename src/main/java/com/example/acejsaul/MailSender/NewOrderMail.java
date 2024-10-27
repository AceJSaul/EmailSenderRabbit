package com.example.acejsaul.MailSender;

import com.example.acejsaul.MailSender.javaMail.JavaGmailSender;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class NewOrderMail {

    private static final String QUEUE = "mail-receiving-queue";
    private static final JavaGmailSender gmailSender = new JavaGmailSender();

    public static void main(String[] argv) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            //sendEmail(message);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> { });
    }

    private static void sendEmail(String message){
        gmailSender.sendSimpleMessage("acejsaul2@gmail.com", "Test Receiving Email", message);
    }
}
