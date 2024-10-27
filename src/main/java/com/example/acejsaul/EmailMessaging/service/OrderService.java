package com.example.acejsaul.EmailMessaging.service;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.model.Order;
import com.example.acejsaul.EmailMessaging.model.Product;
import com.example.acejsaul.EmailMessaging.model.dto.OrderDTO;
import com.example.acejsaul.EmailMessaging.model.mappingDTO.MappingClasses;
import com.example.acejsaul.EmailMessaging.rabbitmqSender.MessageFormat;
import com.example.acejsaul.EmailMessaging.rabbitmqSender.Send;
import com.example.acejsaul.EmailMessaging.repository.ClientRep;
import com.example.acejsaul.EmailMessaging.repository.OrderRep;
import com.example.acejsaul.EmailMessaging.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRep repository;
    @Autowired
    private ClientRep clientRep;
    @Autowired
    private ProductRep productRep;


    public Order findById(UUID id){
        if (repository.findById(id).isEmpty()){
            return null;
        }
        return repository.findById(id).get();
    }

    public Order createOrder(OrderDTO order){
        Client clientOrdering = clientRep.findById(order.clientId()).orElseThrow();
        List<Product> productsOrdering = new ArrayList<>();
        for (Long id : order.productId()) productsOrdering.add(productRep.findById(id).orElseThrow());

        Order orderToBeSaved = new Order(UUID.randomUUID(), clientOrdering, productsOrdering);
        Send.sendMessage(new MessageFormat<Order> (orderToBeSaved));
        return repository.save(orderToBeSaved);
    }
}
