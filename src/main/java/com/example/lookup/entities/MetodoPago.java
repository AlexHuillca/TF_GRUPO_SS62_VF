package com.example.lookup.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Long idMetodoPago;

    @Column(name = "tipo_pago", length = 50, nullable = false)
    private String tipoPago;

    @Column(name = "detalle_registro", length = 100)
    private String detalleRegistro;
}
