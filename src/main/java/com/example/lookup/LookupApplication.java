package com.example.lookup;

import com.example.lookup.entities.Authority;
import com.example.lookup.entities.AuthorityName;
import com.example.lookup.repository.AuthorityRepository;
import com.example.lookup.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LookupApplication {

    public static void main(String[] args) {
        SpringApplication.run(LookupApplication.class, args);
    }
    @Bean
    public CommandLineRunner mappingDemo(
            AuthorityRepository authorityRepository
    ) {
        return args -> {
            // Crear autoridades
            if (authorityRepository.findByName(AuthorityName.ROLE_ADMIN) == null) {
                authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
            }
            if (authorityRepository.findByName(AuthorityName.ROLE_CLIENTE) == null) {
                authorityRepository.save(new Authority(AuthorityName.ROLE_CLIENTE));
            }
            if (authorityRepository.findByName(AuthorityName.READ) == null) {
                authorityRepository.save(new Authority(AuthorityName.READ));
            }
            if (authorityRepository.findByName(AuthorityName.WRITE) == null) {
                authorityRepository.save(new Authority(AuthorityName.WRITE));
            }
        };
    }
}
