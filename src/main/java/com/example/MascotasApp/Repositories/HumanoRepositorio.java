package com.example.MascotasApp.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MascotasApp.Models.Humano;

@Repository //Indica que es un repositorio
public class HumanoRepositorio {
    //Autowired sirve para que se cree una instancia de JdbcTemplate automáticamente
    //JdbcTemplate sirve para hacer consultas a la base de datos
    //HAY QUE PONER SIEMPRE EL jdbcTemplate SIEMPREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void crearHumano(Humano humano){ //Crea un dueño con su nombre y si está activo o no
        String query = "INSERT INTO humano (nombre,activo) VALUES (?,?)";
        jdbcTemplate.update(query,humano.getNombre(),humano.isActivo());
    }

    public List<Humano> getTodosHumanos(){ //Devuelve una lista de dueños con todos los datos
        String query = "SELECT * FROM humano";
        List<Humano> listaHumanos = jdbcTemplate.query(query, new HumanoRowMapper());
        //Se hace la query y se le pasa el RowMapper para que sepa como mapear los datos
        return listaHumanos;
    }


    public List<Humano> getTodosHumanosActivos(){ //Devuelve una lista de dueños con todos los datos
        String query = "SELECT * FROM humano WHERE activo = true";
        List<Humano> listaHumanos = jdbcTemplate.query(query, new HumanoRowMapper());
        //Se hace la query y se le pasa el RowMapper para que sepa como mapear los datos
        return listaHumanos;
    }

    public void cambiarEstadoHumano(Humano humano){ //Cambia el estado de un dueño para la adopcion
        //Cambio el estado si es true a false y viceversa
        String query = "UPDATE humano SET activo = CASE WHEN activo = true THEN false ELSE true END WHERE id = ?";
        jdbcTemplate.update(query,humano.getId());
    }

}
