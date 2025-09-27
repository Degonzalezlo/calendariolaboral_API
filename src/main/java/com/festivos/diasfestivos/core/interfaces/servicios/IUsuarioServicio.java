package com.festivos.diasfestivos.core.interfaces.servicios;

import java.util.List;
import com.festivos.diasfestivos.dominio.entidades.*;
import com.festivos.diasfestivos.dominio.DTOs.*;

public interface IUsuarioServicio {

    public UsuarioLoginDto login(String nombreUsuario, String clave);

    public List<Usuario> listar();

    public Usuario obtener(Long id);

    public List<Usuario> buscar(String nombre);

    public Usuario agregar(Usuario Usuario);

    public Usuario modificar(Usuario Usuario);

    public boolean eliminar(Long id);
}