package com.example.lookup.Controller;

import com.example.lookup.Services.MarcaService;
import com.example.lookup.dtos.MarcaDTO;
import com.example.lookup.entities.Marca;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MarcaContoller {

    @Autowired
    private MarcaService service;

    @Autowired
    private ModelMapper mp;

    @PostMapping("/marca")
    public ResponseEntity<Object> save(@RequestBody MarcaDTO MarcaDTO) {
        Marca p = mp.map(MarcaDTO, Marca.class);

        service.save(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/marcas")
    public ResponseEntity<Object> list() {
        return new ResponseEntity<>(service.list(),
                HttpStatus.OK);
    }

}
