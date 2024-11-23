package com.example.lookup.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria_prenda")
public class CategoriaPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "nombre_categoria", length = 50, nullable = false)
    private String nombreCategoria;

    @Column(name = "descripcion_categoria", length = 100)
    private String descripcionCategoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCategoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Prenda> prendas = new LinkedHashSet<>();
}