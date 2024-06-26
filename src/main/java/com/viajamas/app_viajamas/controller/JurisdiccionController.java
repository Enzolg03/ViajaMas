package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.bd.Pais;
import com.viajamas.app_viajamas.model.dto.JurisdiccionDto;
import com.viajamas.app_viajamas.service.JurisdiccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "api/v1/jurisdicciones")
public class JurisdiccionController {

    private JurisdiccionService jurisdiccionService;

    @GetMapping("")
    public ResponseEntity<List<Jurisdiccion>> listarJurisdicciones(){
        List<Jurisdiccion> jurisdiccionList = new ArrayList<>(jurisdiccionService.listarJurisdicciones());
        if(jurisdiccionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jurisdiccionList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Jurisdiccion> registrarJurisdiccion(
            @RequestBody JurisdiccionDto jurisdiccionDto
    ){
        Jurisdiccion nuevaJurisdiccion = new Jurisdiccion();
        Jurisdiccion result = jurisdiccionService.guardarJurisdiccion(nuevaJurisdiccion, jurisdiccionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Jurisdiccion> actualizarJurisdiccion(
            @PathVariable Integer id,
            @RequestBody JurisdiccionDto jurisdiccionDto
    ){
        Jurisdiccion nuevaJurisdiccion = jurisdiccionService.obtenerJurisdiccionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La jurisdiccion con Id" +
                        + id + " no existe"));
        Jurisdiccion result = jurisdiccionService.guardarJurisdiccion(nuevaJurisdiccion, jurisdiccionDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJurisdiccion(@PathVariable Integer id) {
        Jurisdiccion jurisdiccion = jurisdiccionService.obtenerJurisdiccionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La jurisdicción con Id " + id + " no existe"));
        jurisdiccionService.eliminarJurisdiccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
