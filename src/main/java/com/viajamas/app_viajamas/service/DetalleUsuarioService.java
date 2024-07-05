package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.viajamas.app_viajamas.model.bd.Rol;
import com.viajamas.app_viajamas.model.bd.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = obtenerUsuarioXNomusuario(username);
        return autenticacionUsuario(usuario,
                obtenerListaRoles(usuario.getRoles()));
    }
    public Usuario obtenerUsuarioXNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    public List<GrantedAuthority> obtenerListaRoles(Set<Rol> listaRoles){
        List<GrantedAuthority> roles = new ArrayList<>();
        for(Rol rol : listaRoles){
            roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getNomrol()));
        }
        /*listaRoles.forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        });*/
        return roles;
    }
    private UserDetails autenticacionUsuario(Usuario usuario,
                                                  List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(),
                true, true, true,
                authorityList);
    }

}
