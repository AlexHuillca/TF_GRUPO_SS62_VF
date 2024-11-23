package com.example.lookup.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String Nombre_Usuario;
        private String password;
        private String correo;
        private String direccion;
        private Date fecha_registro;
        private boolean enabled;
        private String genero;
        private Long edad;
        private String dni;
        @JsonManagedReference
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "users_authorities", joinColumns = {
                        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
        }, inverseJoinColumns = {
                        @JoinColumn(name = "authority_id", referencedColumnName = "id", nullable = false)
        })
        private List<Authority> authorities;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference
        private List<Preferencias_usuarios> preferencia;

}
