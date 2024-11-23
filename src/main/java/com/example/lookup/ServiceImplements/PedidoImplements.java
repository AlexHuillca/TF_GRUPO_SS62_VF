package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.PedidoService;
import com.example.lookup.entities.Pedido;
import com.example.lookup.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImplements implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public Pedido save(Pedido p)
    {
        return pedidoRepository.save(p);
    }

    @Override
    public List<Pedido>list()
    {
        return pedidoRepository.findAll();
    }


    @Override
    public String delete(Long id)
        {
            if(pedidoRepository.findById(id)== null)
            {
                return "no se encontro el pedido";
            }
            else {

                pedidoRepository.deleteById(id);
                return "pedido eliminado";
            }


        }
}
