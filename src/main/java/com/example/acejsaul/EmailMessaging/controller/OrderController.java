package com.example.acejsaul.EmailMessaging.controller;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.model.Order;
import com.example.acejsaul.EmailMessaging.model.dto.OrderDTO;
import com.example.acejsaul.EmailMessaging.service.ClientService;
import com.example.acejsaul.EmailMessaging.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderByUUID(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order createNewOrder(@RequestBody OrderDTO order){
        return service.createOrder(order);
    }
}
