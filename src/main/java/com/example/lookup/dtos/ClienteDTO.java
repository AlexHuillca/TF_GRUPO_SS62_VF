package com.example.lookup.dtos;

import com.example.lookup.entities.Pedido;
import com.example.lookup.entities.User;
import com.example.lookup.entities.Valoracion;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String nombreCliente;
    private User idUsuario;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Valoracion> valoracions = new ArrayList<>();
}
