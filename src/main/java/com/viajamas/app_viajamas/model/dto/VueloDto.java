package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class VueloDto {
    private Integer idvuelo;
    private String numerovuelo;
    private Integer aerolinea;
    private Integer avion;
    private Integer aeropuerto_origen;
    private Integer aeropuerto_destino;
    private String fechasalida;
    private String fechallegada;
    private Integer duracion;
}
