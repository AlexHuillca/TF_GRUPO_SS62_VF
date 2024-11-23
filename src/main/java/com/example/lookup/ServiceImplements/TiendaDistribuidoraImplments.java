package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.TiendaDistribuidoraService;
import com.example.lookup.entities.TiendaDistribuidora;
import com.example.lookup.repository.TiendaDistribuidoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaDistribuidoraImplments implements TiendaDistribuidoraService {

    @Autowired
    TiendaDistribuidoraRepository tiendaDistribuidoraRepository;

    @Override
    public TiendaDistribuidora save(TiendaDistribuidora t)
    {
        return tiendaDistribuidoraRepository.save(t);
    }

    @Override
    public List<TiendaDistribuidora>list( )
    {
        return tiendaDistribuidoraRepository.findAll();
    }

    @Override
    public String delete(Long id)
    {
        if(tiendaDistribuidoraRepository.findById(id)== null)
        {
            return "no se encontro en la base de datos";
        }

        else {tiendaDistribuidoraRepository.deleteById(id);
            return "eliminado de la base de datos";

        }
    }
}
