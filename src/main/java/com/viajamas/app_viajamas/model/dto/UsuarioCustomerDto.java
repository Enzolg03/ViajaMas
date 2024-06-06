package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class UsuarioCustomerDto {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
    private String password;
}
