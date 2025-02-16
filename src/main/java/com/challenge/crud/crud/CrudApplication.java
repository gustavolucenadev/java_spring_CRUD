package com.challenge.crud.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("TESTE!");

    }
}
