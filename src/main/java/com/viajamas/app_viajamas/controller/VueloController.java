package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Vuelo;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import com.viajamas.app_viajamas.model.dto.VueloDto;
import com.viajamas.app_viajamas.service.IVueloService;
import com.viajamas.app_viajamas.service.VueloService;
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

@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/vuelos")
public class VueloController {
    private IVueloService iVueloService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> listarAeropuertoDto(){
        List<DtoEntity> aerolineaDtoList = new ArrayList<>();
        aerolineaDtoList = iVueloService.listarVuelos()
                .stream()
                .map(x -> new DtoUtil().convertirADtoAnidado(x, new VueloDto()))
                .collect(Collectors.toList());
        if(aerolineaDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(aerolineaDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVueloXId(@PathVariable Integer id){
        Vuelo vueloObtenido = iVueloService.obtenerVueloxId(id)
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
        Vuelo result = iVueloService.guardarVuelo(nuevoVuelo, vueloDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(
            @PathVariable Integer id,
            @RequestBody VueloDto vueloDto
    ){
        Vuelo nuevoVuelo = iVueloService.obtenerVueloxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Vuelo con Id" +
                        + id + " no existe"));
        Vuelo result = iVueloService.guardarVuelo(nuevoVuelo, vueloDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}
