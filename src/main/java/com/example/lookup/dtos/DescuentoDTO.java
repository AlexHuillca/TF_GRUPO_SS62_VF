
package com.example.lookup.dtos;

import com.example.lookup.entities.Prenda;
import com.example.lookup.entities.TiendaDistribuidora;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DescuentoDTO {
    private Long idDescuento;
    private String codigoDescuento;
    private BigDecimal porcentajeDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Prenda idPrenda;
    private TiendaDistribuidora idTienda;
}
