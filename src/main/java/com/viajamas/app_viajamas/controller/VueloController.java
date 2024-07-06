package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Aeropuerto;
import com.viajamas.app_viajamas.model.bd.Vuelo;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;
import com.viajamas.app_viajamas.model.dto.VueloDto;
import com.viajamas.app_viajamas.service.VueloService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/vuelos")
public class VueloController {
    private VueloService vueloService;

    @GetMapping("")
    public ResponseEntity<List<Vuelo>> listarVuelos(){
        List<Vuelo> vueloList = new ArrayList<>(vueloService.listarVuelos());
        if(vueloList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vueloList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVueloXId(@PathVariable Integer id){
        Vuelo vueloObtenido = vueloService.obtenerVueloxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Vuelo con Id" +
                        + id + " no existe"));
        return new ResponseEntity<>(vueloObtenido,
                HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Vuelo> registrarVuelo(
            @RequestBody VueloDto vueloDto
    ){
        Vuelo nuevoVuelo = new Vuelo();
        Vuelo result = vueloService.guardarVuelo(nuevoVuelo, vueloDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(
            @PathVariable Integer id,
            @RequestBody VueloDto vueloDto
    ){
        Vuelo nuevoVuelo = vueloService.obtenerVueloxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Vuelo con Id" +
                        + id + " no existe"));
        Vuelo result = vueloService.guardarVuelo(nuevoVuelo, vueloDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Integer id) {
        Vuelo vuelo = vueloService.obtenerVueloxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Vuelo con Id " + id + " no existe"));
        vueloService.eliminarVuelo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
