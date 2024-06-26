package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Pais;
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
@RequestMapping(path = "/api/v1/paises")
public class PaisController {
    private PaisService paisService;

    @GetMapping("")
    public ResponseEntity<List<Pais>> listarPaises(){
        List<Pais> paisList = new ArrayList<>(paisService.listarPaises());
        if(paisList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paisList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Pais> registrarPais(
            @RequestBody Pais category
    ){
        return new ResponseEntity<>(
                paisService.guardarPais(category), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizarPais(
            @PathVariable Integer id,
            @RequestBody Pais pais
    ){
        Pais nuevoPais = paisService.obtenerPaisxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El país con Id" +
                        + id + " no existe"));
        nuevoPais.setDescripcion(pais.getDescripcion());
        return new ResponseEntity<>(
                paisService.guardarPais(nuevoPais),
                HttpStatus.OK);
    }
    //@DeleteMapping("/{id}")
    //public ResponseEntity<Pais> actualizarPais(
            //@PathVariable Integer id
    //){
        //return new ResponseEntity<>(paisService.eliminarPais(id), HttpStatus.OK);
    //}
}
