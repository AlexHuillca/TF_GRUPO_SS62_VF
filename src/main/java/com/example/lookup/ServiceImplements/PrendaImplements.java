package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.PrendaService;
import com.example.lookup.entities.Prenda;
import com.example.lookup.repository.PrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaImplements implements PrendaService {


    @Autowired
    PrendaRepository prendarepository;

    @Override
    public Prenda save(Prenda p)
    {
        return  prendarepository.save(p);
    }

    @Override

    public List<Prenda> list()
    {
        return  prendarepository.findAll();
    }
    @Override
    public String  delete(Long id)
    {
        if(prendarepository.findById(id)== null)
        {
            return " nose encontro la prenda";
        }else {prendarepository.deleteById(id);
            return "prenda eliminada";}
    }
}
