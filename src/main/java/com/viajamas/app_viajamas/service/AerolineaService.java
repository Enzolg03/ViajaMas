package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Aerolinea;
import com.viajamas.app_viajamas.model.bd.Pais;
import com.viajamas.app_viajamas.model.dto.AerolineaDto;
import com.viajamas.app_viajamas.repository.AerolineaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AerolineaService implements IAerolineaService{

    private AerolineaRepository aerolineaRepository;

    @Override
    public Aerolinea guardarAerolinea(Aerolinea aerolinea, AerolineaDto aerolineaDto) {
        aerolinea.setNombre(aerolineaDto.getNombre());
        Pais pais = new Pais();
        pais.setIdpais(aerolineaDto.getIdpais());
        aerolinea.setPais(pais);
        return aerolineaRepository.save(aerolinea);
    }

    @Override
    public List<Aerolinea> listarAerolineas() {
        return aerolineaRepository.findAll();
    }

    @Override
    public void eliminarAerolinea(int idaerolinea) {
        aerolineaRepository.deleteById(idaerolinea);
    }

    @Override
    public Optional<Aerolinea> obtenerAerolineaxId(Integer id) {
        Optional<Aerolinea> aerolinea= aerolineaRepository.findById(id);
        if(aerolinea.isEmpty()){
            return aerolinea;
        }
        return aerolinea;
    }
}
