package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.repository.CiudadRepository;

import java.util.List;
import java.util.Optional;

public class CiudadService implements ICiudadService{
    private CiudadRepository ciudadRepository;
    @Override
    public Ciudad guardarCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) {
        ciudadRepository.actualizarCiudad(ciudad.getDescripcion(), ciudad.getIdjurisdiccion(), ciudad.getIdciudad());
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    public void eliminarCiudad(int idciudad) {
        ciudadRepository.deleteById(idciudad);
    }
    @Override
    public Optional<Ciudad> obtenerCiudadxId(Integer id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if(ciudad.isEmpty()){
            return ciudad;
        }
        return ciudad;
    }
}
