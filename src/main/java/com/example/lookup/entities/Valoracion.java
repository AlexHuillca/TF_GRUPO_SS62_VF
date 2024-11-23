package com.example.lookup.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion", nullable = false)
    private Long idValoracion;

    @Column(name = "comentario_valoracion", length = 300, nullable = false)
    private String comentarioValoracion;

    @Column(name = "puntuacion_valoracion", nullable = false)
    private Integer puntuacionValoracion;

    @Column(name = "fecha_comentario", nullable = false)
    private LocalDate fechaComentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente clienteIdCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedidoIdPedido;
}