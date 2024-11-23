package com.example.lookup.repository;

import com.example.lookup.dtos.PrendasDisponiblesDTO;
import com.example.lookup.entities.PrendaTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaTiendaRepository extends JpaRepository<PrendaTienda,Long>
{
    //HU12: Ver el listado de todas las prendas disponibles.
    @Query("select new com.example.lookup.dtos.PrendasDisponiblesDTO(pt.prendaIdPrenda.nombrePrenda,pt.idTienda.nombreTienda,pt.stockDisponible,pt.prendaIdPrenda.precioFinal) from PrendaTienda pt where pt.disponible= true order by pt.stockDisponible")
    public List<PrendasDisponiblesDTO> prendasDisponibles();
}
