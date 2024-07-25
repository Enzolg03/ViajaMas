package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class VueloDto implements DtoEntity{
    private Integer idvuelo;
    private String numerovuelo;
    private Integer idaerolinea;
    private String nomaerolinea;
    private Integer idavion;
    private String modelo;
    private Integer id_aeropuerto_origen;
    private String nomaeropuerto_origen;
    private Integer id_aeropuerto_destino;
    private String nomaeropuerto_destino;
    private String fechasalida;
    private String fechallegada;
    private Integer duracion;
}
