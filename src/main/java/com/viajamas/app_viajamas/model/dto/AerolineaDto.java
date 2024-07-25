package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class AerolineaDto implements DtoEntity{
    private Integer  idaerolinea;
    private String nomaerolinea;
    private Integer idpais;
    private String nompais;
}
