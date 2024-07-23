package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class AerolineaDto implements DtoEntity{
    private Integer  idaerolinea;
    private String nombre;
    private Integer idpais;
    private String descripcion;
}
