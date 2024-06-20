package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.dto.JurisdiccionDto;

import java.util.List;
import java.util.Optional;

public interface IJurisdiccionService {
    Jurisdiccion guardarJurisdiccion(Jurisdiccion jurisdiccion, JurisdiccionDto jurisdiccionDto);
    List<Jurisdiccion> listarJurisdicciones();
    void eliminarJurisdiccion(int idjurisdiccion);
    Optional<Jurisdiccion> obtenerJurisdiccionxId(Integer id);

}
