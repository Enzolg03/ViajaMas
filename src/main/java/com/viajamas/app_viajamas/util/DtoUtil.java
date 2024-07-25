package com.viajamas.app_viajamas.util;

import com.viajamas.app_viajamas.model.bd.Vuelo;
import com.viajamas.app_viajamas.model.dto.VueloDto;
import com.viajamas.app_viajamas.model.dto.DtoEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {

    private final ModelMapper modelMapper;

    public DtoUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        configureMappings();
    }

    private void configureMappings() {
        modelMapper.typeMap(Vuelo.class, VueloDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getAeropuerto_origen().getIdaeropuerto(), VueloDto::setId_aeropuerto_origen);
            mapper.map(src -> src.getAeropuerto_destino().getIdaeropuerto(), VueloDto::setId_aeropuerto_destino);
        });
    }

    public DtoEntity convertirADto(Object obj, DtoEntity mapper) {
        return modelMapper.map(obj, mapper.getClass());
    }

    public DtoEntity convertirADtoAnidado(Object obj, DtoEntity mapper) {
        return modelMapper.map(obj, mapper.getClass());
    }

    public Object convertirDtoAEntity(Object obj, DtoEntity mapper) {
        return modelMapper.map(mapper, obj.getClass());
    }
}

