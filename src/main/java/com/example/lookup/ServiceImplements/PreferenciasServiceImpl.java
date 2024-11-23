package com.example.lookup.ServiceImplements;


import com.example.lookup.Services.PreferenciasService;
import com.example.lookup.entities.Preferencias_usuarios;
import com.example.lookup.exceptions.IncompleteDataException;
import com.example.lookup.exceptions.ResourceNotFoundException;
import com.example.lookup.repository.PreferenciasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenciasServiceImpl implements PreferenciasService {

    @Autowired
    private PreferenciasRepository preferenciasRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Preferencias_usuarios save(Preferencias_usuarios preferenciasUsuarios) {
        if (preferenciasUsuarios.getUser() == null || preferenciasUsuarios.getUser().isEnabled()){
            throw new IncompleteDataException("El usuario no puede ser nulo");
        }

        if (preferenciasUsuarios.getTipo_prenda_favorito() == null || preferenciasUsuarios.getTipo_prenda_favorito().isBlank()){
            throw new IncompleteDataException("El tipo de prenda no puede estar vacio");
        }

        if (preferenciasUsuarios.getTalla_favorita() == null || preferenciasUsuarios.getTalla_favorita().isBlank()){
            throw new IncompleteDataException("La talla no puede estar vacia");
        }
        return preferenciasRepository.save(preferenciasUsuarios);
    }

    @Override
    public Preferencias_usuarios findbyId(Long id) {
        Preferencias_usuarios preferencia = preferenciasRepository.findById(id).orElse(null);
        if(preferencia == null){
            throw new ResourceNotFoundException("No existe la preferencia con el id: "+String.valueOf(id));
        }
        return preferencia;
    }

    @Override
    public Preferencias_usuarios update(Preferencias_usuarios preferenciasUsuarios) {
        if (preferenciasUsuarios.getId() == null){
            throw new IncompleteDataException("El id no puede ser nulo");
        }

        Preferencias_usuarios preferencia = preferenciasRepository.findById(preferenciasUsuarios.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No existe la preferencia con el id: "+String.valueOf(preferenciasUsuarios.getId())));


        modelMapper.map(preferenciasUsuarios,preferencia);
        return preferenciasRepository.save(preferencia);
    }

    @Override
    public void delete(Long id) {
        Preferencias_usuarios prefr = findbyId(id);
        if(prefr == null){
            throw new ResourceNotFoundException("La preferencia con id: " + id + "no se encuentra");
        }

        preferenciasRepository.delete(prefr);

    }
}
