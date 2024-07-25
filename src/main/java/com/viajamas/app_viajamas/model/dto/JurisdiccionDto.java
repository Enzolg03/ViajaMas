package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class JurisdiccionDto implements DtoEntity{
    private Integer idjurisdiccion;
    private String nomjurisdiccion;
    private Integer idpais;
    private String nompais;
}
