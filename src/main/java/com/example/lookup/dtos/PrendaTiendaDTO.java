package com.example.lookup.dtos;

import com.example.lookup.entities.Prenda;
import com.example.lookup.entities.TiendaDistribuidora;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrendaTiendaDTO {
    private Long idPrendaTienda;
    private LocalDate fechaIngreso;
    private Integer stockDisponible;
    private Boolean disponible;
    private TiendaDistribuidora idTienda;
    private Prenda prendaIdPrenda;
}
