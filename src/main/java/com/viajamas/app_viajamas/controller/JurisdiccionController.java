package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import com.viajamas.app_viajamas.model.dto.JurisdiccionDto;
import com.viajamas.app_viajamas.service.IJurisdiccionService;
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
@RequestMapping(path = "api/v1/jurisdicciones")
public class JurisdiccionController {

    private IJurisdiccionService iJurisdiccionService;
    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> listarJurisdiccionDto(){
        List<DtoEntity> aerolineaDtoList = new ArrayList<>();
        aerolineaDtoList = iJurisdiccionService.listarJurisdicciones()
                .stream()
                .map(x -> new DtoUtil().convertirADtoAnidado(x, new JurisdiccionDto()))
                .collect(Collectors.toList());
        if(aerolineaDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(aerolineaDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jurisdiccion> obtenerJurisdiccionXId(@PathVariable Integer id){
        Jurisdiccion jurisdiccionObtenido = iJurisdiccionService.obtenerJurisdiccionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La jurisdiccion con Id" +
                        + id + " no existe"));
        return new ResponseEntity<>(jurisdiccionObtenido,
                HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Jurisdiccion> registrarJurisdiccion(@RequestBody JurisdiccionDto jurisdiccionDto) {
        Jurisdiccion nuevaJurisdiccion = new Jurisdiccion();
        Jurisdiccion result = iJurisdiccionService.guardarJurisdiccion(nuevaJurisdiccion, jurisdiccionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jurisdiccion> actualizarJurisdiccion(@PathVariable Integer id,
                                                               @RequestBody JurisdiccionDto jurisdiccionDto) {
        Jurisdiccion jurisdiccion = iJurisdiccionService.obtenerJurisdiccionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La jurisdiccion con Id " + id + " no existe"));
        Jurisdiccion result = iJurisdiccionService.guardarJurisdiccion(jurisdiccion, jurisdiccionDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
