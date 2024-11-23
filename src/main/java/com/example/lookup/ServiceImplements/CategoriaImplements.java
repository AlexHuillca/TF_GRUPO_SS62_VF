package com.example.lookup.ServiceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lookup.Services.CategoriaPrendaService;
import com.example.lookup.entities.CategoriaPrenda;
import com.example.lookup.repository.CategoriaPrendaRepository;

@Service
public class CategoriaImplements implements CategoriaPrendaService {

    @Autowired
    CategoriaPrendaRepository Categoriarepository;

    @Override
    public CategoriaPrenda save(CategoriaPrenda p) {
        return Categoriarepository.save(p);
    }

    @Override

    public List<CategoriaPrenda> list() {
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
