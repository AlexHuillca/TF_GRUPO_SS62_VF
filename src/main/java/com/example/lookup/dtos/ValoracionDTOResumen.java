package com.example.lookup.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValoracionDTOResumen {

    private String comentario;

    private Integer puntacion;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntacion() {
        return puntacion;
    }

    public void setPuntacion(Integer puntacion) {
        this.puntacion = puntacion;
    }
}
