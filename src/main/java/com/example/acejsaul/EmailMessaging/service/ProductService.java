package com.example.acejsaul.EmailMessaging.service;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.model.Product;
import com.example.acejsaul.EmailMessaging.repository.ClientRep;
import com.example.acejsaul.EmailMessaging.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRep repository;

    public Product findById(Long id){
        if (repository.findById(id).isEmpty()){
            return null;
        }
        return repository.findById(id).get();
    }

    public Product createClient(Product product){
        return repository.save(product);
    }
}
