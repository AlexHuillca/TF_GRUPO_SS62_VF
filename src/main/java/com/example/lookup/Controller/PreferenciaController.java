package com.example.lookup.Controller;

import com.example.lookup.Services.PreferenciasService;
import com.example.lookup.entities.Preferencias_usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PreferenciaController {

    @Autowired
    PreferenciasService preferenciasService;

    @PostMapping("/preferencia/register")
    public ResponseEntity<Preferencias_usuarios> createPreferencia(@RequestBody Preferencias_usuarios prefe) {
        Preferencias_usuarios newPrefer = preferenciasService.save(prefe);
        if (newPrefer==null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newPrefer, HttpStatus.CREATED);
    }


    @PutMapping("/preferencia")
    public ResponseEntity<Preferencias_usuarios> updatePreferencia(@RequestBody Preferencias_usuarios prefe) {
        Preferencias_usuarios updPrefer = preferenciasService.update(prefe);
        if (updPrefer==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(updPrefer, HttpStatus.OK);
    }


    @GetMapping("/preferencia/{id}")
    public ResponseEntity<Preferencias_usuarios> getPrefrById(@PathVariable("id") Long id) {
        Preferencias_usuarios preferencia = preferenciasService.findbyId(id);
        return ResponseEntity.ok(preferencia);
    }

    @DeleteMapping("/preferencia/{id}")
    public ResponseEntity<HttpStatus> deletePrefrById(@PathVariable("id") Long id) {
        preferenciasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
