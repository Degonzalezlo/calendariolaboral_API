package com.festivos.diasfestivos.core.interfaces.servicios;

import com.festivos.diasfestivos.dominio.entidades.Calendario;
import java.util.List;



public interface ICalendarioServicio {
    
    public boolean generar(int idPais, int año);

    public List<Calendario> listar(int idPais, int año);

    

}
