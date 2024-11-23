package com.example.lookup.Controller;

import com.example.lookup.Services.PreferenciaUsuarioService;
import com.example.lookup.dtos.PreferenciadeusuarioDTO;
import com.example.lookup.entities.Preferencias_usuarios;
import com.example.lookup.entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PreferenciaUsuarioController {


    @Autowired
    private PreferenciaUsuarioService preferenciaUsuarioService;

    @Autowired
    private ModelMapper mp;


    @PostMapping("/AgregarPreferencia")
    public ResponseEntity<Object> save (@RequestBody PreferenciadeusuarioDTO preferenciadeusuarioDTO)
    {
        mp  = new ModelMapper();
        Preferencias_usuarios p = mp.map(preferenciadeusuarioDTO, Preferencias_usuarios.class);
        User u = new User();
        u.setId(preferenciadeusuarioDTO.getIdUsuario());
        p.setUser(u);

        if(preferenciadeusuarioDTO.getId() != null){
            p = preferenciaUsuarioService.find(preferenciadeusuarioDTO.getId());
            p.setColor_favorito(preferenciadeusuarioDTO.getColor_favorito());
            p.setCategoria(preferenciadeusuarioDTO.getCategoria());
            p.setMarca(preferenciadeusuarioDTO.getMarca());
            p.setTalla_favorita(preferenciadeusuarioDTO.getTalla_favorita());
            p.setTipo_prenda_favorito(preferenciadeusuarioDTO.getTipo_prenda_favorito());
        }

        preferenciaUsuarioService.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    @GetMapping("/preferencias/{id}")
    public ResponseEntity<Object>list(@PathVariable Long id)
    {
        mp= new ModelMapper();
        return new ResponseEntity<>(preferenciaUsuarioService.list(id),HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/preferencia/{id}")
    public ResponseEntity<String> delete(@RequestBody Long id)
    {
        mp= new ModelMapper();

        return  new ResponseEntity<String>(preferenciaUsuarioService.eliminar(id),HttpStatus.OK);
    }
}
