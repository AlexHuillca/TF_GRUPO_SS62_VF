package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.DescuentoService;
import com.example.lookup.entities.Descuento;
import com.example.lookup.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoImplements implements DescuentoService {
    @Autowired
    private DescuentoRepository descuentoRepository;

    @Override
    public Descuento save(Descuento d)
    {
        return descuentoRepository.save(d);
    }

    @Override
    public List<Descuento> list()
    {
        return descuentoRepository.findAll();
    }

    @Override
    public String delete(Long id)
    {
        if(descuentoRepository.findById(id)== null)
        {
            return "no se encontro el descuento";
        }
        else descuentoRepository.deleteById(id);
        return "descuento eliminado de la base de datos";
    }
}
