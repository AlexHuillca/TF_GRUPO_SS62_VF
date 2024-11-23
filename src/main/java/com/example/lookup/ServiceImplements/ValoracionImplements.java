package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.ValoracionService;
import com.example.lookup.dtos.ValoracionDTOResumen;
import com.example.lookup.entities.Valoracion;
import com.example.lookup.repository.ValoracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionImplements implements ValoracionService {

    @Autowired
    private ValoracionRepositorio valoracionRepositorio;

    @Override
    public List<ValoracionDTOResumen>resumen_comentario(){
        return valoracionRepositorio.ResumenComentarios();
    }



    @Override
    public Valoracion save(Valoracion v)
    {
        return  valoracionRepositorio.save(v);
    }

    @Override
    public String Eliminar(Long id)
    {
        if(valoracionRepositorio.findById(id)==null)
        {
            return "no se encontro la volariacion";
        }else {

            valoracionRepositorio.deleteById(id);
            return "valoracion eliminada";
        }
    }
}
