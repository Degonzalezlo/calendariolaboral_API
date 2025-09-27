package com.festivos.diasfestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.festivos.diasfestivos.dominio.entidades.Festivo;

import java.util.List;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {

     @Query("SELECT f FROM Festivo f WHERE f.nombre LIKE '%' || ?1 || '%' ORDER BY f.nombre ASC")
    public List<Festivo> buscar(String nombre);

    @Query("SELECT f FROM Festivo f WHERE f.pais.id=:idPais ORDER BY f.nombre ASC")
    public List<Festivo> listarPorPais(int idPais);

}
