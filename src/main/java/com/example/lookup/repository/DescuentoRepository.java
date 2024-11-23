package com.example.lookup.repository;

import com.example.lookup.entities.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento,Long> {
}
