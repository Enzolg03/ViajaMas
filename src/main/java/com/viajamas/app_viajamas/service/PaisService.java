package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Pais;
import com.viajamas.app_viajamas.repository.PaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaisService implements IPaisService{

    private PaisRepository paisRepository;
    @Override
    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    //@Override
   //public void actualizarPais(Pais pais) {
        //paisRepository.actualizarPais(
                ///pais.getDescripcion(),pais.getIdpais()
        //);
    ///}

    @Override
    public List<Pais> listarPaises() {
        return paisRepository.findAll();
    }

    //@Override
    //public Optional eliminarPais(int idpais) {
        //return paisRepository.deleteById(idpais);
    //}

    @Override
    public Optional<Pais> obtenerPaisxId(Integer id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if(pais.isEmpty()){
            return pais;
        }
        return pais;
    }
}
