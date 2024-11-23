package com.example.lookup.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre_cliente", length = 100, nullable = false)
    private String nombreCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private User idUsuario;

    @OneToMany(mappedBy = "idCliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "clienteIdCliente")
    private List<Valoracion> valoracions = new ArrayList<>();
}
