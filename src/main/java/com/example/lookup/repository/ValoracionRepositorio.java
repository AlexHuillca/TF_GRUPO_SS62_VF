package com.example.lookup.repository;

import com.example.lookup.dtos.ValoracionDTOResumen;
import com.example.lookup.entities.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepositorio extends JpaRepository<Valoracion,Long> {
    @Query("SELECT new com.example.lookup.dtos.ValoracionDTOResumen(v.comentarioValoracion, v.puntuacionValoracion)"
    + "from Valoracion v")
    List<ValoracionDTOResumen>ResumenComentarios();
}
