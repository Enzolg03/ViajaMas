package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.model.dto.CiudadDto;

import java.util.List;
import java.util.Optional;

public interface ICiudadService {
    Ciudad guardarCiudad(Ciudad ciudad, CiudadDto ciudadDto);
    List<Ciudad> listarCiudades();
    void eliminarCiudad(int idciudad);
    Optional<Ciudad> obtenerCiudadxId(Integer id);

}
