package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class CiudadDto implements DtoEntity{
    private Integer idciudad;
    private String nomciudad;
    private Integer idjurisdiccion;
    private String nomjurisdiccion;
}
