package com.example.lookup.ServiceImplements;

import com.example.lookup.Services.PreferenciaUsuarioService;
import com.example.lookup.entities.Preferencias_usuarios;
import com.example.lookup.repository.PreferenciaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrefereneciaUsuarioImplements implements PreferenciaUsuarioService {
    @Autowired
    private PreferenciaUsuarioRepository preferenciaUsarioRepository;

    @Override
    public Preferencias_usuarios save(Preferencias_usuarios preferenciasUsuario)
    {
        return preferenciaUsarioRepository.save(preferenciasUsuario);
    }

    @Override
    public Preferencias_usuarios list(Long usuarioId) {
        return preferenciaUsarioRepository.listar(usuarioId);
    }

    @Override
    public String eliminar(Long id)
    {
        if(preferenciaUsarioRepository.findById(id)==null)
        {
            return "La preferencia no existe";
        }else {
            preferenciaUsarioRepository.deleteById(id);
            return"Preferencia de suario eliminada";}

    }

    @Override
    public Preferencias_usuarios find(Long id) {
        return preferenciaUsarioRepository.findById(id).get();
    }

}
