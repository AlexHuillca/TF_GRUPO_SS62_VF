package com.example.lookup.Controller;

import com.example.lookup.Services.ValoracionService;
import com.example.lookup.dtos.ValoracionDTO;
import com.example.lookup.dtos.ValoracionDTOResumen;
import com.example.lookup.entities.Valoracion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ValoracionController {


    @Autowired
    private ValoracionService valoracionService;

ModelMapper mp;

    @GetMapping("/cometarios")
    public ResponseEntity<List<ValoracionDTOResumen>> cometarios()
    {
        return new ResponseEntity<List<ValoracionDTOResumen>>(valoracionService.resumen_comentario(), HttpStatus.OK);
    }

    @PostMapping("/valoracion")
    public ResponseEntity<ValoracionDTO>save (@RequestBody ValoracionDTO valoracionDTO)
    {
        mp = new ModelMapper();

        Valoracion v = mp.map(valoracionDTO, Valoracion.class);

        valoracionService.save(v);

        return  new ResponseEntity<ValoracionDTO>(valoracionDTO,HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/Valoracion/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id)
    {
        return new ResponseEntity<String>(valoracionService.Eliminar(id),HttpStatus.OK);
    }
}
