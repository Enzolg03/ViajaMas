package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Ciudad;
import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.dto.CiudadDto;
import com.viajamas.app_viajamas.repository.CiudadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CiudadService implements ICiudadService{

    private CiudadRepository ciudadRepository;
    @Override
    public Ciudad guardarCiudad(Ciudad ciudad, CiudadDto ciudadDto) {
        ciudad.setDescripcion(ciudadDto.getDescripcion());
        Jurisdiccion jurisdiccion = new Jurisdiccion();
        jurisdiccion.setIdjurisdiccion(ciudadDto.getIdjurisdiccion());
        ciudad.setJurisdiccion(jurisdiccion);
        return ciudadRepository.save(ciudad);
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
        Optional<Ciudad> ciudad= ciudadRepository.findById(id);
        if(ciudad.isEmpty()){
            return ciudad;
        }
        return ciudad;
    }
}
