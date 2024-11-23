package com.example.lookup.Services;

import com.example.lookup.entities.Preferencias_usuarios;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface PreferenciaUsuarioService {
    public Preferencias_usuarios save(Preferencias_usuarios preferenciasUsuario);
    public Preferencias_usuarios list(Long usuarioId);
    public Preferencias_usuarios find(Long id);
    public String eliminar(Long id);
}
