package com.example.lookup.Services;

import com.example.lookup.entities.Descuento;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface DescuentoService {
    public Descuento save(Descuento d);
    public List<Descuento> list();
    public String delete(Long id);
}
