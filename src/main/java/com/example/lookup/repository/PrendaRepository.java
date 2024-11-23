package com.example.lookup.repository;

import com.example.lookup.entities.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda,Long> {
}
