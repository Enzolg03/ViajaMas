package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Vuelo;
import com.viajamas.app_viajamas.model.dto.VueloDto;


import java.util.List;
import java.util.Optional;

public interface IVueloService {
    Vuelo guardarVuelo(Vuelo vuelo, VueloDto vueloDto);
    List<Vuelo> listarVuelos();
    Optional<Vuelo> obtenerVueloxId(Integer id);
}
