package com.challenge.crud.crud.services;


import com.challenge.crud.crud.entities.Client;
import com.challenge.crud.crud.repositories.ClientRepository;
import com.challenge.crud.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // findByID - busca de recursos por ID
    @Transactional(readOnly = true)
    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    // findAll - busca paginada

    // insert

    //update

    // delete








}
