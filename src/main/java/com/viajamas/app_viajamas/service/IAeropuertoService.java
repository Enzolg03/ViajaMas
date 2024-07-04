package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Aeropuerto;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;

import java.util.List;
import java.util.Optional;

public interface IAeropuertoService {
    Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto, AeropuertoDto aeropuertoDto);
    List<Aeropuerto> listarAeropuertos();
    void eliminarAeropuerto(int idaeropuerto);
    Optional<Aeropuerto> obtenerAeropuertoxId(Integer id);
}
