package com.example.lookup.Services;

import com.example.lookup.entities.Preferencias_usuarios;

public interface PreferenciasService {
    public Preferencias_usuarios save(Preferencias_usuarios preferenciasUsuarios);
    public Preferencias_usuarios findbyId(Long id);
    public Preferencias_usuarios update(Preferencias_usuarios preferenciasUsuarios);
    public void delete(Long id);
}
