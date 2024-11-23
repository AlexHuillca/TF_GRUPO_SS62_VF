package com.example.lookup.repository;

import com.example.lookup.entities.CategoriaPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaPrendaRepository extends JpaRepository<CategoriaPrenda, Long> {
}
