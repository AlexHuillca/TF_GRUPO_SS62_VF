package com.example.lookup.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DTOUser {
    private Long id;

    private String Nombre_Usuario;
    private String password;
    private String correo;
    private String direccion;
    private Date fecha_registro;
    private boolean enabled;
    private String type;
    private String celular;
    private String genero;
    private Long edad;
    private String dni;
}
