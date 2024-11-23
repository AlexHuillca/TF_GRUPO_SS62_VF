package com.example.lookup.ServiceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lookup.Services.MarcaService;
import com.example.lookup.entities.Marca;
import com.example.lookup.repository.MarcaRepository;

@Service
public class MarcaImplements implements MarcaService {

    @Autowired
    MarcaRepository Categoriarepository;

    @Override
    public Marca save(Marca p) {
        return Categoriarepository.save(p);
    }

    @Override

    public List<Marca> list() {
        return Categoriarepository.findAll();
    }

    @Override
    public String delete(Long id) {
        if (Categoriarepository.findById(id) == null) {
            return " no se encontro la Categoria";
        } else {
            Categoriarepository.deleteById(id);
            return "Categoria eliminada";
        }
    }
}
