package com.example.lookup.ServiceImplements;

import com.example.lookup.dtos.DetallePedidoDTO;
import com.example.lookup.dtos.PrendasSeleccionadasDTO;
import com.example.lookup.entities.DetallePedido;
import com.example.lookup.entities.Pedido;
import com.example.lookup.exceptions.DetallePedidoNotFoundException;
import com.example.lookup.repository.DetallePedidoRepository;
import com.example.lookup.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetallePedidoServiceImpl {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public DetallePedidoDTO getById(Integer id) {
        DetallePedido detallePedido = detallePedidoRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new DetallePedidoNotFoundException(id));
        return convertToDTO(detallePedido);
    }

    public List<DetallePedidoDTO> getAll() {
        return detallePedidoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DetallePedidoDTO create(DetallePedidoDTO detallePedidoDTO) {
        // Validar si el Pedido existe
        Pedido pedido = pedidoRepository.findById(detallePedidoDTO.getIdDetallePedido())
                .orElseThrow(() -> new DetallePedidoNotFoundException(Math.toIntExact(detallePedidoDTO.getIdDetallePedido())));

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecio(detallePedidoDTO.getPrecio());
        detallePedido.setPedido(pedido);

        return convertToDTO(detallePedidoRepository.save(detallePedido));
    }

    public DetallePedidoDTO update(Integer id, DetallePedidoDTO detallePedidoDTO) {
        DetallePedido detallePedido = detallePedidoRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new DetallePedidoNotFoundException(id));

        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecio(detallePedidoDTO.getPrecio());

        return convertToDTO(detallePedidoRepository.save(detallePedido));
    }

    public void delete(Integer id) {
        if (!detallePedidoRepository.existsById(Long.valueOf(id))) {
            throw new DetallePedidoNotFoundException(id);
        }
        detallePedidoRepository.deleteById(Long.valueOf(id));
    }

    private DetallePedidoDTO convertToDTO(DetallePedido detallePedido) {
        DetallePedidoDTO dto = new DetallePedidoDTO();
        dto.setIdPrendaTienda(detallePedido.getIdPrendaTienda());
        dto.setCantidad(detallePedido.getCantidad());
        dto.setPrecio(detallePedido.getPrecio());
        dto.setCantidad(Math.toIntExact(detallePedido.getPedido().getIdPedido()));
        return dto;
    }
    public List<PrendasSeleccionadasDTO> prendasSeleccionadas (Long pIdCliente){
        return detallePedidoRepository.prendasSeleccionadas(pIdCliente);
    }
}
