package com.example.acejsaul.EmailMessaging.rabbitmqSender;

import java.io.Serializable;

public class MessageFormat<T> implements Serializable {

    private T content;

    public MessageFormat(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
