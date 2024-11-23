package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.ClienteService;
import com.example.lookup.entities.Cliente;
import com.example.lookup.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteImplments implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente save(Cliente c)
    {
        return  clienteRepository.save(c);
    }


    @Override
    public List<Cliente>list()
    {
        return clienteRepository.findAll();

    }

    @Override
    public String delete(Long id) {
        if(clienteRepository.findById(id).isEmpty())
        {
            return "no se encontro al cliente";
        }else {
            clienteRepository.deleteById(id);
            return "cliente eliminado";
        }
    }


}
