package com.challenge.crud.crud.services;


import com.challenge.crud.crud.dto.ClientDTO;
import com.challenge.crud.crud.entities.Client;
import com.challenge.crud.crud.repositories.ClientRepository;
import com.challenge.crud.crud.services.exceptions.DatabaseException;
import com.challenge.crud.crud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // findByID - busca de recursos por ID
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ClientDTO(client);
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
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    // delete
    public void delete(Long id) {
        if (!clientRepository.existsById(id))
            throw new ResourceNotFoundException("Recurso não encontrado!");
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
    }
}
