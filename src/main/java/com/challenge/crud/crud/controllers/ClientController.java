package com.challenge.crud.crud.controllers;

import com.challenge.crud.crud.dto.ClientDTO;
import com.challenge.crud.crud.entities.Client;
import com.challenge.crud.crud.services.ClientService;
import jakarta.validation.Valid;
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
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {
        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(dto.getID()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @PathVariable Long id, @RequestBody ClientDTO dto) {
        dto = clientService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
