package com.challenge.crud.crud.repositories;

import com.challenge.crud.crud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
