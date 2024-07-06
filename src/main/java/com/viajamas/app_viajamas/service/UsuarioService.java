package com.viajamas.app_viajamas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.viajamas.app_viajamas.model.bd.Usuario;
import com.viajamas.app_viajamas.repository.RolRepository;
import com.viajamas.app_viajamas.repository.UsuarioRepository;


@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;


    @Override
    public Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
