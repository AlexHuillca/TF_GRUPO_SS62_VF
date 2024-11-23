package com.example.lookup.repository;

import com.example.lookup.entities.TiendaDistribuidora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaDistribuidoraRepository extends JpaRepository<TiendaDistribuidora,Long> {
}
