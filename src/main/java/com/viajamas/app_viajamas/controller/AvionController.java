package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Avion;
import com.viajamas.app_viajamas.model.bd.Pais;
import com.viajamas.app_viajamas.service.AvionService;
import com.viajamas.app_viajamas.service.PaisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/api/v1/aviones")
public class AvionController {
    private AvionService avionService;

    @GetMapping("")
    public ResponseEntity<List<Avion>> listarAviones(){
        List<Avion> avionList = new ArrayList<>(avionService.listarAviones());
        if(avionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(avionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avion> obtenerAvionPorId(@PathVariable Integer id) {
        Avion avion = avionService.obtenerAvionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El avion con Id " + id + " no existe"));
        return new ResponseEntity<>(avion, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Avion> registrarAvion(
            @RequestBody Avion category
    ){
        return new ResponseEntity<>(
                avionService.guardarAvion(category), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Avion> actualizarAvion(
            @PathVariable Integer id,
            @RequestBody Avion avion
    ){
        Avion nuevoAvion = avionService.obtenerAvionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El avion con Id" +
                        + id + " no existe"));
        nuevoAvion.setModelo(avion.getModelo());
        nuevoAvion.setCapacidadpasajeros(avion.getCapacidadpasajeros());
        return new ResponseEntity<>(
                avionService.guardarAvion(nuevoAvion),
                HttpStatus.OK);
    }
}
