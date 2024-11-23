package com.example.lookup.dtos;

import lombok.Data;

@Data
public class PreferenciadeusuarioDTO {
    private Long id;
    private String color_favorito;
    private String tipo_prenda_favorito;
    private String talla_favorita;
    private String tipo_evento;
    private Integer categoria;
    private Integer marca;
    private Long idUsuario;
}
