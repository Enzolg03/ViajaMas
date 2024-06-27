package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Avion;
import com.viajamas.app_viajamas.repository.AvionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvionService implements IAvionService{

    private AvionRepository avionRepository;

    @Override
    public Avion guardarAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public List<Avion> listarAviones() {
        return avionRepository.findAll();
    }

    @Override
    public Optional<Avion> obtenerAvionxId(Integer id) {
        Optional<Avion> avion = avionRepository.findById(id);
        if(avion.isEmpty()){
            return avion;
        }
        return avion;
    }
}
