package com.festivos.diasfestivos.core.interfaces.servicios;

import com.festivos.diasfestivos.dominio.entidades.TipoFestivo;

import java.util.List;

public interface ITipoFestivoServicio {

   public List<TipoFestivo> listar();

    public TipoFestivo obtener(int id);

    public List<TipoFestivo> buscar(String nombre);

    public TipoFestivo agregar(TipoFestivo TipoFestivo);

    public TipoFestivo modificar(TipoFestivo TipoFestivo);

    public boolean eliminar(int id);
}
