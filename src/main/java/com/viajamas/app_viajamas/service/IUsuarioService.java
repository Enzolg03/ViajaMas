package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
