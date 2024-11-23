package com.example.lookup.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PrendaDTO {
    private Long id;
    private String nombrePrenda;
    private String tipoPrenda;
    private String colorPrenda;
    private String talla;
    private BigDecimal precioOriginal;
    private BigDecimal precioFinal;
    private Long idmarca;
    private Long idcategoria;
    private String url;
}
