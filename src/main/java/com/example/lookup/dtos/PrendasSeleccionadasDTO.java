package com.example.lookup.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrendasSeleccionadasDTO {
    private String nombreCliente;
    private String nombrePrenda;
    private Integer cantPrendas;
}
