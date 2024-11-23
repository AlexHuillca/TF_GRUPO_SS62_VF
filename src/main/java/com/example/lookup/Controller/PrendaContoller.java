package com.example.lookup.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookup.Services.PrendaService;
import com.example.lookup.dtos.PrendaDTO;
import com.example.lookup.entities.CategoriaPrenda;
import com.example.lookup.entities.Marca;
import com.example.lookup.entities.Prenda;

@RestController
@RequestMapping("/api")
public class PrendaContoller {

    @Autowired
    private PrendaService prendaService;

    @Autowired
    private ModelMapper mp;

    @PostMapping("/prenda")
    public ResponseEntity<Object> save(@RequestBody PrendaDTO prendaDTO) {
        Prenda p = mp.map(prendaDTO, Prenda.class);
        p.setIdMarca(new Marca(prendaDTO.getIdmarca(), null));
        p.setIdCategoria(new CategoriaPrenda(prendaDTO.getIdcategoria(), null, null, null));
        p.setUrl(prendaDTO.getUrl());

        System.out.println(p);

        prendaService.save(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/prendas")
    public ResponseEntity<Object> list() {
        
        return new ResponseEntity<>(prendaService.list(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/prenda/{id}")

    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>("{\"mensaje\":\"" + prendaService.delete(id) + "\"}", HttpStatus.OK);
    }

}
