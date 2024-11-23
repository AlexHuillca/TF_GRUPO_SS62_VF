package com.example.lookup.dtos;

import com.example.lookup.entities.Descuento;
import com.example.lookup.entities.PrendaTienda;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDistribuidoraDTO {
    private Long idTienda;
    private String nombreTienda;
    private List<Descuento> descuentos = new ArrayList<>();
    private List<PrendaTienda> prendaTiendas = new ArrayList<>();
}
