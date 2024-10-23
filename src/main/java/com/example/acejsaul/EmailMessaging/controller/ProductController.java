package com.example.acejsaul.EmailMessaging.controller;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.model.Product;
import com.example.acejsaul.EmailMessaging.service.ClientService;
import com.example.acejsaul.EmailMessaging.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product createNewProduct(@RequestBody Product product){
        return service.createClient(product);
    }
}
