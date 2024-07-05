package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    Usuario guardarUsuarioCliente(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario buscarUsuarioXIdUsuario(Integer idusuario);
    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
