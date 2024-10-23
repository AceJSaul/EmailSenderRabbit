package com.example.acejsaul.EmailMessaging.repository;

import com.example.acejsaul.EmailMessaging.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, Long> {
}
