package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.*;
import com.viajamas.app_viajamas.model.dto.AeropuertoDto;
import com.viajamas.app_viajamas.repository.AeropuertoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AeropuertoService implements IAeropuertoService{

    private AeropuertoRepository aeropuertoRepository;
    @Override
    public Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto, AeropuertoDto aeropuertoDto) {
        aeropuerto.setNombre(aeropuertoDto.getNombre());
        Ciudad ciudad = new Ciudad();
        Jurisdiccion jurisdiccion = new Jurisdiccion();
        Pais pais = new Pais();
        ciudad.setIdciudad(aeropuertoDto.getIdciudad());
        jurisdiccion.setIdjurisdiccion(aeropuertoDto.getIdjurisdiccion());
        pais.setIdpais(aeropuertoDto.getIdpais());
        aeropuerto.setCiudad(ciudad);
        aeropuerto.setJurisdiccion(jurisdiccion);
        aeropuerto.setPais(pais);
        return aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public List<Aeropuerto> listarAeropuertos() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public void eliminarAeropuerto(int idaeropuerto) {
        aeropuertoRepository.deleteById(idaeropuerto);
    }

    @Override
    public Optional<Aeropuerto> obtenerAeropuertoxId(Integer id) {
        Optional<Aeropuerto> aeropuerto= aeropuertoRepository.findById(id);
        if(aeropuerto.isEmpty()){
            return aeropuerto;
        }
        return aeropuerto;
    }
}
