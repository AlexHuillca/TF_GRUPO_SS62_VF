package com.example.lookup.entities;

import com.example.lookup.entities.Prenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tienda_distribuidora")
public class TiendaDistribuidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Long idTienda;

    @Column(name = "nombre_tienda", length = 100, nullable = false)
    private String nombreTienda;

    @OneToMany(mappedBy = "idTienda")
    private List<Descuento> descuentos = new ArrayList<>();

    @OneToMany(mappedBy = "idTienda")
    private List<PrendaTienda> prendaTiendas = new ArrayList<>();
}
