package com.example.lookup.Services;

import com.example.lookup.dtos.ValoracionDTOResumen;
import com.example.lookup.entities.Valoracion;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public interface ValoracionService {
    List<ValoracionDTOResumen>resumen_comentario();
    Valoracion save(Valoracion v);
    String Eliminar(Long id);
}
