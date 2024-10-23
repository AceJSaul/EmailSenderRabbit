package com.example.acejsaul.EmailMessaging.repository;

import com.example.acejsaul.EmailMessaging.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client, Long> {
}
