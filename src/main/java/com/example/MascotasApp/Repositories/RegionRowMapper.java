package com.example.MascotasApp.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

import com.example.MascotasApp.Models.Region;



public class RegionRowMapper implements RowMapper<Region> {
    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public Region mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        //Se crea un objeto Region con los datos del resultSet, que es el resultado de la query
        Region region = new Region();
        region.setId(resultSet.getInt("id"));
        region.setNombre(resultSet.getString("nombre"));
        return region;
    }
}
