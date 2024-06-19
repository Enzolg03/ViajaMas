package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Pais;

import java.util.List;
import java.util.Optional;

public interface IPaisService {
    Pais guardarPais(Pais pais);
    //void actualizarPais(Pais pais);
    List<Pais> listarPaises();
    //Optional eliminarPais(int idpais);
    Optional<Pais> obtenerPaisxId(Integer id);
}
