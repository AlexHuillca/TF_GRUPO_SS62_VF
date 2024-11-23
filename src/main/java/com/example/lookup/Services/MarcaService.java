package com.example.lookup.Services;

import com.example.lookup.entities.Marca;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface MarcaService {
    Marca save(Marca p);
    List<Marca> list();
    String  delete (Long id);
}
