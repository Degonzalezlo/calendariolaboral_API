package com.festivos.diasfestivos.aplicacion;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.festivos.diasfestivos.core.interfaces.repositorios.IUsuarioRepositorio;
import com.festivos.diasfestivos.core.interfaces.servicios.IUsuarioServicio;
import com.festivos.diasfestivos.dominio.DTOs.UsuarioLoginDto;
import com.festivos.diasfestivos.dominio.entidades.Usuario;


@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    // Comentar o eliminar la siguiente línea durante las pruebas
    // @Autowired
    // private SeguridadServicio servicioSeguridad;

    @Override
    public UsuarioLoginDto login(String nombreUsuario, String clave) {
        Usuario usuarioObtenido = repositorio.validarUsuario(nombreUsuario, clave);
        if (usuarioObtenido == null) {
            return null; // O lanzar excepción según necesidad
        }
        UsuarioLoginDto userLoginResponseDto = new UsuarioLoginDto(usuarioObtenido);
        // En pruebas no generamos token
        // userLoginResponseDto.setToken(servicioSeguridad.generarToken(nombreUsuario));
        return userLoginResponseDto;
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @Override
    public Usuario obtener(Long id) {
        var usuario = repositorio.findById(id);
        return usuario.isEmpty() ? null : usuario.get();
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    public Usuario agregar(Usuario usuario) {
        usuario.setId(0);
        return repositorio.save(usuario);
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = repositorio.findById(usuario.getId());
        if (usuarioEncontrado.isPresent()) {
            return repositorio.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}