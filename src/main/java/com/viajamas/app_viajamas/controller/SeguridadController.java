package com.viajamas.app_viajamas.controller;

import com.viajamas.app_viajamas.model.dto.UsuarioCustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.viajamas.app_viajamas.model.bd.Usuario;
import com.viajamas.app_viajamas.model.dto.ResultadoDto;
import com.viajamas.app_viajamas.model.dto.UsuarioDto;
import com.viajamas.app_viajamas.service.UsuarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "seguridad")
public class SeguridadController {
    private UsuarioService usuarioService;
    @GetMapping("/usuario")
    public String frmMantUsuario(Model model){
        model.addAttribute("listaUsuarios",
                usuarioService.listarUsuario());
        return "seguridad/formusuario";
    }
    @PostMapping("/usuario")
    @ResponseBody
    public ResultadoDto registrarUsuario(@RequestBody UsuarioDto usuarioDto){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try {
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioDto.getNombres());
            usuario.setApellidos(usuarioDto.getApellidos());
            if(usuarioDto.getIdusuario() > 0){
                usuario.setIdusuario(usuarioDto.getIdusuario());
                usuario.setActivo(usuarioDto.getActivo());
                usuarioService.actualizarUsuario(usuario);
            }else{
                usuario.setNomusuario(usuarioDto.getNomusuario());
                usuario.setEmail(usuarioDto.getEmail());
                usuarioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD";
            respuesta = false;
        }
        return ResultadoDto.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
    @PostMapping("/customer")
    @ResponseBody
    public ResultadoDto registrarUsuario(@RequestBody UsuarioCustomerDto usuarioCustomerDto){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try {
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioCustomerDto.getNombres());
            usuario.setApellidos(usuarioCustomerDto.getApellidos());
            if(usuarioCustomerDto.getIdusuario()>0){
                usuario.setIdusuario(usuarioCustomerDto.getIdusuario());
                usuario.setActivo(usuarioCustomerDto.getActivo());
            }
            usuario.setNomusuario(usuarioCustomerDto.getNomusuario());
            usuario.setEmail(usuarioCustomerDto.getEmail());
            usuario.setPassword(usuarioCustomerDto.getPassword());
            usuarioService.guardarUsuarioCliente(usuario);
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD";
            respuesta = false;
        }
        return ResultadoDto.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario frmMantUsuario(@PathVariable("id") int id){
        return usuarioService.buscarUsuarioXIdUsuario(id);
    }
    @GetMapping("/usuario/lista")
    @ResponseBody
    public List<Usuario> listaUsuario(){
        return usuarioService.listarUsuario();
    }

}
