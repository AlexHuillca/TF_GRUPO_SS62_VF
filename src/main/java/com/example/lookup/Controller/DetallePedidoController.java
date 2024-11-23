package com.example.lookup.Controller;

import com.example.lookup.ServiceImplements.DetallePedidoServiceImpl;
import com.example.lookup.dtos.DetallePedidoDTO;
import com.example.lookup.dtos.PrendasSeleccionadasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoServiceImpl detallePedidoServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> getDetallePedidoById(@PathVariable Integer id) {
        return ResponseEntity.ok(detallePedidoServiceImpl.getById(id));
    }

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> createDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoServiceImpl.create(detallePedidoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallePedidoDTO detallePedidoDTO) {
        return ResponseEntity.ok(detallePedidoServiceImpl.update(id, detallePedidoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        detallePedidoServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{pIdCliente}")
    public List<PrendasSeleccionadasDTO> prendasSeleccionadas (Long pIdCliente){
        return detallePedidoServiceImpl.prendasSeleccionadas(pIdCliente);
    }
}