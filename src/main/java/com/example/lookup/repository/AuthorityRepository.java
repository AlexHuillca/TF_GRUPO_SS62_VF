package com.example.lookup.repository;


import com.example.lookup.entities.Authority;
import com.example.lookup.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByName(AuthorityName name);
}
