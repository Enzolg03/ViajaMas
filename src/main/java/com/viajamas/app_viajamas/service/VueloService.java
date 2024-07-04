package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.*;
import com.viajamas.app_viajamas.model.dto.VueloDto;
import com.viajamas.app_viajamas.repository.VueloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VueloService implements IVueloService{

    private VueloRepository vueloRepository;
    @Override
    public Vuelo guardarVuelo(Vuelo vuelo, VueloDto vueloDto) {
        vuelo.setNumerovuelo(vueloDto.getNumerovuelo());
        vuelo.setFechasalida(vueloDto.getFechasalida());
        vuelo.setFechallegada(vueloDto.getFechallegada());
        vuelo.setDuracion(vueloDto.getDuracion());

        Aerolinea aerolinea = new Aerolinea();
        Avion avion = new Avion();
        Aeropuerto origen = new Aeropuerto();
        Aeropuerto destino = new Aeropuerto();

        aerolinea.setIdaerolinea(vueloDto.getAerolinea());
        avion.setIdavion(vueloDto.getAvion());
        origen.setIdaeropuerto(vueloDto.getAeropuerto_origen());
        destino.setIdaeropuerto(vueloDto.getAeropuerto_destino());

        vuelo.setAerolinea(aerolinea);
        vuelo.setAvion(avion);
        vuelo.setAeropuerto_origen(origen);
        vuelo.setAeropuerto_destino(destino);

        return vueloRepository.save(vuelo);
    }

    @Override
    public List<Vuelo> listarVuelos() {
        return vueloRepository.findAll();
    }

    @Override
    public void eliminarVuelo(int idvuelo) {
        vueloRepository.deleteById(idvuelo);
    }

    @Override
    public Optional<Vuelo> obtenerVueloxId(Integer id) {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);
        if(vuelo.isEmpty()){
            return vuelo;
        }
        return vuelo;
    }
}
