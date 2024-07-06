package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
