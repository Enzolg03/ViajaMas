package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class AeropuertoDto implements DtoEntity{
    private Integer idaeropuerto;
    private String nomaeropuerto;
    private Integer idciudad;
    private String nomciudad;
    private Integer idjurisdiccion;
    private String nomjurisdiccion;
    private Integer idpais;
    private String nompais;
}
