package com.upc.closetlabel.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "descuentos")
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento", nullable = false)
    private Integer id;

    @Column(name = "codigo_descuento", length = 50)
    private String codigoDescuento;

    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prenda")
    private Prenda idPrenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tienda")
    private TiendaDistribuidora idTienda;

}
