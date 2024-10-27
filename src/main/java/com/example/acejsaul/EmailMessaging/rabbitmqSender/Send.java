package com.example.acejsaul.EmailMessaging.rabbitmqSender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class Send {

    private final static String QUEUE_NAME = "mail-receiving-queue";
    private final static ConnectionFactory factory = new ConnectionFactory();
    private static final Logger logger = Logger.getLogger(Send.class.getName());

    public static <T extends Serializable> void sendMessage(MessageFormat<T> message){
        factory.setHost("localhost");
        // Cria uma Queue
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Transforma a mensagem em um JSON, que pode ser transformado em bytes
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Como o Jackson não suporta o transporte de Instant, foi preciso, primeiramente, transformar o Instant em uma String para que ela possa transportar
            byte[] messageBytes = objectMapper.writeValueAsBytes(message);

            logger.info("Sending message");
            channel.basicPublish("", QUEUE_NAME, null, messageBytes);
        }
        catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
