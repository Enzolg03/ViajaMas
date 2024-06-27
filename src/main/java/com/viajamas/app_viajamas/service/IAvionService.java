package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Avion;
import com.viajamas.app_viajamas.model.bd.Pais;

import java.util.List;
import java.util.Optional;

public interface IAvionService {
    Avion guardarAvion(Avion avion);
    //void actualizarPais(Pais pais);
    List<Avion> listarAviones();
    //Optional eliminarPais(int idpais);
    Optional<Avion> obtenerAvionxId(Integer id);
}
