package com.viajamas.app_viajamas.model.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class JurisdiccionDto {
    private Integer idjurisdiccion;
    private String descripcion;
    private Integer idpais;
}
