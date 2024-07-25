package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.model.dto.AerolineaDto;
import com.viajamas.app_viajamas.model.dto.CiudadDto;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import com.viajamas.app_viajamas.service.CiudadService;
import com.viajamas.app_viajamas.service.ICiudadService;
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

@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR', 'WORKER')")
@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/ciudades")
public class CiudadController {
    private ICiudadService iCiudadService;
    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> listarAerolineasDto(){
        List<DtoEntity> aerolineaDtoList = new ArrayList<>();
        aerolineaDtoList = iCiudadService.listarCiudades()
                .stream()
                .map(x -> new DtoUtil().convertirADtoAnidado(x, new CiudadDto()))
                .collect(Collectors.toList());
        if(aerolineaDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(aerolineaDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadXId(@PathVariable Integer id){
        Ciudad ciudadObtenido = iCiudadService.obtenerCiudadxId(id)
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
        Ciudad result = iCiudadService.guardarCiudad(nuevaCiudad, ciudadDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> actualizarCiudad(
            @PathVariable Integer id,
            @RequestBody CiudadDto ciudadDto
    ){
        Ciudad nuevaCiudad = iCiudadService.obtenerCiudadxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La ciudad con Id" +
                        + id + " no existe"));
        Ciudad result = iCiudadService.guardarCiudad(nuevaCiudad, ciudadDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}
