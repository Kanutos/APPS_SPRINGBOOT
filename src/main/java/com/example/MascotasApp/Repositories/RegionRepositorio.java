package com.example.MascotasApp.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MascotasApp.Models.Region;

@Repository //Indica que es un repositorio
public class RegionRepositorio {
    //Autowired sirve para que se cree una instancia de JdbcTemplate automáticamente
    //JdbcTemplate sirve para hacer consultas a la base de datos
    //HAY QUE PONER SIEMPRE EL jdbcTemplate SIEMPREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Region> getTodasRegiones(){ //Devuelve una lista de regiones con todos los datos
        String query = "SELECT * FROM region;";
        List<Region> listaRegiones = jdbcTemplate.query(query, new RegionRowMapper());
        //Se hace la query y se le pasa el RowMapper para que sepa como mapear los datos
        return listaRegiones;
    }

    public void crearRegion(Region region){ //Crea una region con su id y nombre
        String query = "INSERT INTO region (nombre) VALUES (?)";
        jdbcTemplate.update(query,region.getNombre());
    }

    public void eliminarRegion(Region region) {
        
        // Continuar con la eliminación si la verificación es exitosa
        String query1 = "DELETE FROM mascota WHERE region = ?";
        jdbcTemplate.update(query1, region.getId());
    
        String query2 = "DELETE FROM region WHERE id = ?";
        jdbcTemplate.update(query2, region.getId());
    }
    
    public boolean hayMasDeUnaMascotaEnLaRegion(Region region) {
        // Consultar la base de datos para verificar si hay más de una mascota en la región
        String query = "SELECT COUNT(DISTINCT humano_id) FROM mascota WHERE region = ?";
        int cantidadHumanosEnLaRegion = jdbcTemplate.queryForObject(query, Integer.class, region.getId());
    
        // Si hay más de un entrenador en la región, hay más de un Pokémon de diferentes entrenadores
        return cantidadHumanosEnLaRegion > 1;
    }

}
