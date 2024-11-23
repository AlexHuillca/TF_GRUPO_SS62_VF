package com.example.lookup.dtos;

import com.example.lookup.entities.Cliente;
import com.example.lookup.entities.Pedido;
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
public class ValoracionDTO {
    private Long idValoracion;
    private String comentarioValoracion;
    private Integer puntuacionValoracion;
    private LocalDate fechaComentario;
    private Cliente clienteIdCliente;
    private Pedido pedidoIdPedido;
}
