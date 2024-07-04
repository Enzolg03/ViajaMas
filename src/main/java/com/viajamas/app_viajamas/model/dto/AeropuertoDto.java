package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class AeropuertoDto {
    private Integer idaeropuerto;
    private String nombre;
    private Integer idciudad;
    private Integer idjurisdiccion;
    private Integer idpais;
}
