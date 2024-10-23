package com.example.acejsaul.EmailMessaging.controller;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClientById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client createNewClient(@RequestBody Client client){
        return service.createClient(client);
    }
}
