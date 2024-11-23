package com.example.lookup.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrendasDisponiblesDTO {
    private String nombrePrenda;
    private String nombreTienda;
    private Integer stockDisponible;
    private BigDecimal precio;
}
