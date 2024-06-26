package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Aerolinea;
import com.viajamas.app_viajamas.model.dto.AerolineaDto;

import java.util.List;
import java.util.Optional;

public interface IAerolineaService {
    Aerolinea guardarAerolinea(Aerolinea aerolinea, AerolineaDto aerolineaDto);
    List<Aerolinea> listarAerolineas();
    void eliminarAerolinea(int idaerolinea);
    Optional<Aerolinea> obtenerAerolineaxId(Integer id);
}
