package com.example.lookup.Services;

import com.example.lookup.entities.CategoriaPrenda;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface CategoriaPrendaService {
    CategoriaPrenda save(CategoriaPrenda p);
    List<CategoriaPrenda> list();
    String  delete (Long id);
}
