package com.example.lookup.repository;

import com.example.lookup.entities.Preferencias_usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenciasRepository extends JpaRepository<Preferencias_usuarios,Long> {
}