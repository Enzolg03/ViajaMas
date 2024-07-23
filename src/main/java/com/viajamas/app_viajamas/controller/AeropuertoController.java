package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Aeropuerto;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;
import com.viajamas.app_viajamas.service.AeropuertoService;
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
@RequestMapping(path = "api/v1/aeropuertos")
public class AeropuertoController {
    private AeropuertoService aeropuertoService;

    @GetMapping("")
    public ResponseEntity<List<Aeropuerto>> listarAeropuertos(){
        List<Aeropuerto> aeropuertoList = new ArrayList<>(aeropuertoService.listarAeropuertos());
        if(aeropuertoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(aeropuertoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> obtenerAeropuertoXId(@PathVariable Integer id){
        Aeropuerto aeropuertoObtenido = aeropuertoService.obtenerAeropuertoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Aeropuerto con Id" +
                        + id + " no existe"));
        return new ResponseEntity<>(aeropuertoObtenido,
                HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Aeropuerto> registrarAeropuerto(
            @RequestBody AeropuertoDto aeropuertoDto
    ){
        Aeropuerto nuevaAeropuerto = new Aeropuerto();
        Aeropuerto result = aeropuertoService.guardarAeropuerto(nuevaAeropuerto, aeropuertoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(
            @PathVariable Integer id,
            @RequestBody AeropuertoDto aeropuertoDto
    ){
        Aeropuerto nuevoAeropuerto = aeropuertoService.obtenerAeropuertoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El aeropuerto con Id" +
                        + id + " no existe"));
        Aeropuerto result = aeropuertoService.guardarAeropuerto(nuevoAeropuerto, aeropuertoDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAeropuerto(@PathVariable Integer id) {
        Aeropuerto aeropuerto = aeropuertoService.obtenerAeropuertoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El aeropuerto con Id " + id + " no existe"));
        aeropuertoService.eliminarAeropuerto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
