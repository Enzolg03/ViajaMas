package com.viajamas.app_viajamas.model.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class CiudadDto {
    private Integer idciudad;
    private String descripcion;
    private Integer idjurisdiccion;
}
