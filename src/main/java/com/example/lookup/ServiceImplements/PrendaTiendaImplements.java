package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.PrendaTiendaService;
import com.example.lookup.dtos.PrendasDisponiblesDTO;
import com.example.lookup.entities.PrendaTienda;
import com.example.lookup.repository.PrendaTiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaTiendaImplements implements PrendaTiendaService {
    @Autowired
    private PrendaTiendaRepository prendaTiendaRepository;

    @Override
    public PrendaTienda save(PrendaTienda p)
    {
        return prendaTiendaRepository.save(p);
    }

    @Override
    public List<PrendaTienda>list()
    {
        return prendaTiendaRepository.findAll();
    }

    @Override
    public String delete(Long id)
    {
        if(prendaTiendaRepository.findById(id)==null)
        {
            return" nose encontro la prenda seleccionada";
        }else {prendaTiendaRepository.deleteById(id);
        return "prenda eliminada de la base de datos";}
    }

    @Override
    public List<PrendasDisponiblesDTO> prendasDisponibles() {
        return prendaTiendaRepository.prendasDisponibles();
    }
}
