package com.example.acejsaul.EmailMessaging.repository;

import com.example.acejsaul.EmailMessaging.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRep extends JpaRepository<Order, UUID> {
}

