package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import com.viajamas.app_viajamas.model.bd.Pais;
import com.viajamas.app_viajamas.model.dto.JurisdiccionDto;
import com.viajamas.app_viajamas.repository.JurisdiccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JurisdiccionService implements IJurisdiccionService{

    private JurisdiccionRepository jurisdiccionRepository;

    @Override
    public Jurisdiccion guardarJurisdiccion(Jurisdiccion jurisdiccion, JurisdiccionDto jurisdiccionDto) {
        jurisdiccion.setDescripcion(jurisdiccionDto.getDescripcion());

        // Crear un objeto Pais solo con el ID
        Pais pais = new Pais();
        pais.setIdpais(jurisdiccionDto.getIdpais());

        // Asignar el país al objeto jurisdiccion
        jurisdiccion.setPais(pais);

        // Guardar en la base de datos
        return jurisdiccionRepository.save(jurisdiccion);
    }

    @Override
    public List<Jurisdiccion> listarJurisdicciones() {
        return jurisdiccionRepository.findAll();
    }

    @Override
    public void eliminarJurisdiccion(int idjurisdiccion) {
        jurisdiccionRepository.deleteById(idjurisdiccion);
    }

    @Override
    public Optional<Jurisdiccion> obtenerJurisdiccionxId(Integer id) {
        Optional<Jurisdiccion> jurisdiccion= jurisdiccionRepository.findById(id);
        if(jurisdiccion.isEmpty()){
            return jurisdiccion;
        }
        return jurisdiccion;
    }
}
