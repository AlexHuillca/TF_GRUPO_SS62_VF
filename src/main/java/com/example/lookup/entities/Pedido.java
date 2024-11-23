package com.example.lookup.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "direccion_entrega", length = 200)
    private String direccionEntrega;

    @Column(name = "total_pedido", nullable = false)
    private BigDecimal totalPedido;

    @Column(name = "estado_envio", length = 50, nullable = false)
    private String estadoEnvio;

    @Column(name = "numero_seguimiento", nullable = false)
    private Integer numeroSeguimiento;

    @Column(name = "num_factura", nullable = false)
    private Integer numFactura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago idMetodoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_pedido")
    private EstadoPedido idEstadoPedido;

    @OneToMany(mappedBy = "pedidoIdPedido")
    private Set<Valoracion> valoracions = new LinkedHashSet<>();
}
