package com.example.lookup.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preferencias_usuarios")
public class Preferencias_usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color_favorito;
    private String tipo_prenda_favorito;
    private String talla_favorita;
    private String tipo_evento;
    private Integer categoria;
    private Integer marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}
