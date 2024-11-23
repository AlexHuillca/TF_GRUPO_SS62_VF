package com.example.lookup.Controller;

import com.example.lookup.Services.CategoriaPrendaService;
import com.example.lookup.dtos.CategoriaDTO;
import com.example.lookup.entities.CategoriaPrenda;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CategoriaContoller {

    @Autowired
    private CategoriaPrendaService service;

    @Autowired
    private ModelMapper mp;

    @PostMapping("/categoria")
    public ResponseEntity<Object> save(@RequestBody CategoriaDTO CategoriaDTO) {
        CategoriaPrenda p = mp.map(CategoriaDTO, CategoriaPrenda.class);

        service.save(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/categorias")
    public ResponseEntity<Object> list() {
        System.out.println(service.list());
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

}
