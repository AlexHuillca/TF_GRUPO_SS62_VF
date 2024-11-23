package com.example.lookup.dtos;

import com.example.lookup.entities.Pedido;
import com.example.lookup.entities.PrendaTienda;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {
    private Long idDetallePedido;
    private Double precio;
    private Integer cantidad;
    private Pedido pedido;
    private PrendaTienda idPrendaTienda;
}
