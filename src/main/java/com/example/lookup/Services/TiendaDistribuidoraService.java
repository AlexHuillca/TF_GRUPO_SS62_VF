package com.example.lookup.Services;

import com.example.lookup.entities.TiendaDistribuidora;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface TiendaDistribuidoraService {
    TiendaDistribuidora save(TiendaDistribuidora t);
    List<TiendaDistribuidora> list();
    String delete(Long id);
}
