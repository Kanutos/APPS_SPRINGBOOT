package com.example.MascotasApp.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

import com.example.MascotasApp.Models.Humano;

public class HumanoRowMapper implements RowMapper<Humano>{
    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public Humano mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        //Se crea un objeto Humano con los datos del resultSet, que es el resultado de la query
        Humano humano = new Humano();
        humano.setId(resultSet.getInt("id"));
        humano.setNombre(resultSet.getString("nombre"));
        humano.setActivo(resultSet.getBoolean("activo"));
        return humano;
    }
}
