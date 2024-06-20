package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.service.CiudadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/api/v1/ciudades")
public class CiudadController {
    private CiudadService ciudadService;
    @GetMapping("")
    public ResponseEntity<List<Ciudad>> listarCiudades(){
        List<Ciudad> ciudadList = new ArrayList<>(ciudadService.listarCiudades());
        if(ciudadList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ciudadList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Ciudad> registrarCiudad(
            @RequestBody Ciudad category
    ){
        return new ResponseEntity<>(
                ciudadService.guardarCiudad(category), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> actualizarCiudad(
            @PathVariable Integer id,
            @RequestBody Ciudad ciudad
    ){
        Ciudad nuevoCiudad = ciudadService.obtenerCiudadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El país con Id" +
                        + id + " no existe"));
        nuevoCiudad.setDescripcion(Ciudad.getDescripcion());
        return new ResponseEntity<>(
                ciudadService.guardarCiudad(nuevoCiudad),
                HttpStatus.OK);
    }
}
