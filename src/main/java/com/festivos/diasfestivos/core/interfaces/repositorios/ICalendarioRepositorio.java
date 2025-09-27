package com.festivos.diasfestivos.core.interfaces.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.festivos.diasfestivos.dominio.entidades.Calendario;


@Repository
public interface ICalendarioRepositorio extends JpaRepository<Calendario, Integer> {

    @Query("SELECT c FROM Calendario c WHERE year(c.fecha) = :año AND c.pais.id = :idPais")
    List<Calendario> listarPorAño(@Param("idPais") int idPais, @Param("año") int año);

    @Query("SELECT c FROM Calendario c WHERE c.fecha = :fecha AND c.pais.id = :idPais")
    Calendario obtener(@Param("idPais") int idPais, @Param("fecha") Date fecha);
}