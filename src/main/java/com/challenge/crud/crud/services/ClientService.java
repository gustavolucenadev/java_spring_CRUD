package com.challenge.crud.crud.services;


import com.challenge.crud.crud.dto.ClientDTO;
import com.challenge.crud.crud.entities.Client;
import com.challenge.crud.crud.repositories.ClientRepository;
import com.challenge.crud.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(ClientDTO::new);
    }

    // insert
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    //update

    // delete

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setID(dto.getID());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
    }








}
