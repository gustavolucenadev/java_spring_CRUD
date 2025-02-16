package com.challenge.crud.crud.controllers;

import com.challenge.crud.crud.dto.ClientDTO;
import com.challenge.crud.crud.entities.Client;
import com.challenge.crud.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        ClientDTO dto = new ClientDTO(client);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(dto.getID()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientService.findAll(pageable);
    }
}
