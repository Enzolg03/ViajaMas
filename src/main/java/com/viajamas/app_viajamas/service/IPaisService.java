package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Pais;

import java.util.List;
import java.util.Optional;

public interface IPaisService {
    Pais guardarPais(Pais pais);
    List<Pais> listarPaises();
    Optional<Pais> obtenerPaisxId(Integer id);
}
