package com.example.lookup.entities;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prenda")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prenda")
    private Long id;

    @Column(name = "nombre_prenda", length = 100, nullable = false)
    private String nombrePrenda;

    @Column(name = "tipo_prenda", length = 100, nullable = false)
    private String tipoPrenda;

    @Column(name = "color_prenda", length = 100,nullable = false)
    private String colorPrenda;

    @Column(name = "talla", length = 30, nullable = false)
    private String talla;

    @Column(name = "url", length = 200, nullable = false)
    private String url;

    @Column(name = "precio_original", nullable = false)
    private BigDecimal precioOriginal;

    @Column(name = "precio_final", nullable = false)
    private BigDecimal precioFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Marca idMarca;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_pedido")
//    private Pedido idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "prendas"})
    private CategoriaPrenda idCategoria;

    @OneToMany(mappedBy = "idPrenda")
    @JsonManagedReference
    private Set<Descuento> descuentos = new LinkedHashSet<>();


    @OneToMany(mappedBy = "prendaIdPrenda")
    @JsonManagedReference
    private Set<PrendaTienda> prendaTiendas = new LinkedHashSet<>();

    
}