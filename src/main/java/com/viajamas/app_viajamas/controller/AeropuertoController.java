package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Aeropuerto;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import com.viajamas.app_viajamas.service.IAeropuertoService;
import com.viajamas.app_viajamas.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/aeropuertos")
public class AeropuertoController {
    private IAeropuertoService iAeropuertoService;
    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> listarAeropuertoDto(){
        List<DtoEntity> aerolineaDtoList = new ArrayList<>();
        aerolineaDtoList = iAeropuertoService.listarAeropuertos()
                .stream()
                .map(x -> new DtoUtil().convertirADtoAnidado(x, new AeropuertoDto()))
                .collect(Collectors.toList());
        if(aerolineaDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(aerolineaDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> obtenerAeropuertoXId(@PathVariable Integer id){
        Aeropuerto aeropuertoObtenido = iAeropuertoService.obtenerAeropuertoxId(id)
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
        Aeropuerto result = iAeropuertoService.guardarAeropuerto(nuevaAeropuerto, aeropuertoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(
            @PathVariable Integer id,
            @RequestBody AeropuertoDto aeropuertoDto
    ){
        Aeropuerto nuevoAeropuerto = iAeropuertoService.obtenerAeropuertoxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El aeropuerto con Id" +
                        + id + " no existe"));
        Aeropuerto result = iAeropuertoService.guardarAeropuerto(nuevoAeropuerto, aeropuertoDto);
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
