package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.dto.CiudadDto;
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
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadXId(@PathVariable Integer id){
        Ciudad ciudadObtenido = ciudadService.obtenerCiudadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La ciudad con Id" +
                        + id + " no existe"));
        return new ResponseEntity<>(ciudadObtenido,
                HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Ciudad> registrarCiudad(
            @RequestBody CiudadDto ciudadDto
    ){
        Ciudad nuevaCiudad = new Ciudad();
        Ciudad result = ciudadService.guardarCiudad(nuevaCiudad, ciudadDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> actualizarCiudad(
            @PathVariable Integer id,
            @RequestBody CiudadDto ciudadDto
    ){
        Ciudad nuevaCiudad = ciudadService.obtenerCiudadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La ciudad con Id" +
                        + id + " no existe"));
        Ciudad result = ciudadService.guardarCiudad(nuevaCiudad, ciudadDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable Integer id) {
        Ciudad ciudad = ciudadService.obtenerCiudadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La ciudad con Id " + id + " no existe"));
        ciudadService.eliminarCiudad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
