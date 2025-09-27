package com.festivos.diasfestivos.core.interfaces.servicios;

import com.festivos.diasfestivos.dominio.entidades.Tipo;

import java.util.List;

public interface ITipoServicio {

   public List<Tipo> listar();

    public Tipo obtener(int id);

    public List<Tipo> buscar(String nombre);

    public Tipo agregar(Tipo tipo);

    public Tipo modificar(Tipo tipo);

    public boolean eliminar(int id);
}