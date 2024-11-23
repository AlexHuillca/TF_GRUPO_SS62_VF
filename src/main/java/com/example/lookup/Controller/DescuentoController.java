package com.example.lookup.Controller;

import com.example.lookup.Services.DescuentoService;
import com.example.lookup.dtos.DescuentoDTO;
import com.example.lookup.entities.Descuento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;
ModelMapper mp ;
    @PostMapping("/decuento")
    public ResponseEntity<DescuentoDTO> save(DescuentoDTO descuentoDTO)
    {
        Descuento d = mp.map(descuentoDTO,Descuento.class);
        descuentoService.save(d);
        return new ResponseEntity<DescuentoDTO>(descuentoDTO, HttpStatus.OK);
    }

    @GetMapping("/descuentos")
    public ResponseEntity<List<DescuentoDTO>>list()
    {
        return new ResponseEntity<List<DescuentoDTO>>(Arrays.asList(mp.map(descuentoService.list(),DescuentoDTO[].class)),HttpStatus.OK);

    }
    @DeleteMapping("/eliminar/descuento/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id)
    {
        return new ResponseEntity<String>(descuentoService.delete(id),HttpStatus.OK);
    }

}
