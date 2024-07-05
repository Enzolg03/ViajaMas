package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Aerolinea;
import com.viajamas.app_viajamas.model.dto.AerolineaDto;
import com.viajamas.app_viajamas.service.AerolineaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/aerolineas")
public class AerolineaController {
    private AerolineaService aerolineaService;

    @GetMapping("")
    public ResponseEntity<List<Aerolinea>> listarAerolineas(){
        List<Aerolinea> aerolineaList = new ArrayList<>(aerolineaService.listarAerolineas());
        if(aerolineaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(aerolineaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aerolinea> obtenerAerolineaPorId(@PathVariable Integer id) {
        Aerolinea aerolinea = aerolineaService.obtenerAerolineaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La aerolinea con Id " + id + " no existe"));
        return new ResponseEntity<>(aerolinea, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Aerolinea> registrarAerolinea(
            @RequestBody AerolineaDto aerolineaDto
    ){
        Aerolinea nuevaAerolinea = new Aerolinea();
        Aerolinea result = aerolineaService.guardarAerolinea(nuevaAerolinea, aerolineaDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aerolinea> actualizarAerolinea(
            @PathVariable Integer id,
            @RequestBody AerolineaDto aerolineaDto
    ){
        Aerolinea nuevaAerolinea = aerolineaService.obtenerAerolineaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La aerolinea con Id" +
                        + id + " no existe"));
        Aerolinea result = aerolineaService.guardarAerolinea(nuevaAerolinea, aerolineaDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAerolinea(@PathVariable Integer id) {
        Aerolinea aerolinea = aerolineaService.obtenerAerolineaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La aerolinea con Id " + id + " no existe"));
        aerolineaService.eliminarAerolinea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
