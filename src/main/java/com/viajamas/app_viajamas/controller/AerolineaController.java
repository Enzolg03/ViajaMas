package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.exception.ResourceNotFoundException;
import com.viajamas.app_viajamas.model.bd.Aerolinea;
import com.viajamas.app_viajamas.model.dto.AerolineaDto;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import com.viajamas.app_viajamas.service.IAerolineaService;
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
@RequestMapping(path = "api/v1/aerolineas")
public class AerolineaController {
    private IAerolineaService iAerolineaService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> listarAerolineasDto(){
        List<DtoEntity> aerolineaDtoList = new ArrayList<>();
        aerolineaDtoList = iAerolineaService.listarAerolineas()
                .stream()
                .map(x -> new DtoUtil().convertirADtoAnidado(x, new AerolineaDto()))
                .collect(Collectors.toList());
        if(aerolineaDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(aerolineaDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aerolinea> obtenerAerolineaPorId(@PathVariable Integer id) {
        Aerolinea aerolinea = iAerolineaService.obtenerAerolineaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La aerolinea con Id " + id + " no existe"));
        return new ResponseEntity<>(aerolinea, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Aerolinea> registrarAerolinea(
            @RequestBody AerolineaDto aerolineaDto
    ){
        Aerolinea nuevaAerolinea = new Aerolinea();
        Aerolinea result = iAerolineaService.guardarAerolinea(nuevaAerolinea, aerolineaDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aerolinea> actualizarAerolinea(
            @PathVariable Integer id,
            @RequestBody AerolineaDto aerolineaDto
    ){
        Aerolinea nuevaAerolinea = iAerolineaService.obtenerAerolineaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La aerolinea con Id" +
                        + id + " no existe"));
        Aerolinea result = iAerolineaService.guardarAerolinea(nuevaAerolinea, aerolineaDto);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}
