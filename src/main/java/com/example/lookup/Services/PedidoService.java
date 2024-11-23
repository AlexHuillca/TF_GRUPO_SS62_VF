package com.example.lookup.Services;

import com.example.lookup.entities.Pedido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface PedidoService {
    Pedido save(Pedido p);
    List<Pedido> list();
    String delete(Long id);
}
