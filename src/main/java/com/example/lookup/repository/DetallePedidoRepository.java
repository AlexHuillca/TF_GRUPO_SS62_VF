package com.example.lookup.repository;

import com.example.lookup.dtos.PrendasSeleccionadasDTO;
import com.example.lookup.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    @Query("select new com.example.lookup.dtos.PrendasSeleccionadasDTO(dp.pedido.idCliente.nombreCliente, dp.idPrendaTienda.prendaIdPrenda.nombrePrenda, dp.cantidad) from DetallePedido dp where dp.pedido.idCliente=:pIdCliente group by dp.idDetallePedido")
    public List<PrendasSeleccionadasDTO> prendasSeleccionadas (@Param("pIdCliente") Long pIdCliente);


}