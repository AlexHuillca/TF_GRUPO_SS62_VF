package com.example.lookup.dtos;

import com.example.lookup.entities.*;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Long idPedido;
    private LocalDate fechaPedido;
    private String direccionEntrega;
    private BigDecimal totalPedido;
    private String estadoEnvio;
    private Integer numeroSeguimiento;
    private Integer numFactura;
    private Cliente idCliente;
    private MetodoPago idMetodoPago;
    private EstadoPedido idEstadoPedido;
    private Set<Valoracion> valoracions = new LinkedHashSet<>();
}
