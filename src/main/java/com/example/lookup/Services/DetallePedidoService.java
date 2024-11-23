package com.example.lookup.Services;

import com.example.lookup.dtos.PrendasSeleccionadasDTO;
import com.example.lookup.entities.DetallePedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetallePedidoService {
    public DetallePedido save(DetallePedido dp);
    public List<DetallePedido> list();
    public void delete(Long id);
    public List<PrendasSeleccionadasDTO> prendasSeleccionadas (Long pIdCliente);

}
