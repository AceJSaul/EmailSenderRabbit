package com.example.acejsaul.EmailMessaging.service;

import com.example.acejsaul.EmailMessaging.model.Client;
import com.example.acejsaul.EmailMessaging.repository.ClientRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRep repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        if (repository.findById(id).isEmpty()){
            return null;
        }
        return repository.findById(id).get();
    }

    public Client createClient(Client client){
        return repository.save(client);
    }
}
