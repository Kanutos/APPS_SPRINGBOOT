package com.example.MascotasApp.Repositories;


import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

import com.example.MascotasApp.Models.Humano;
import com.example.MascotasApp.Models.Mascota;
import com.example.MascotasApp.Models.Region;


public class MascotaRowMapper implements RowMapper<Mascota>{
    
    //Override se pone para sobreescribir el método mapRow por defectos
    @Override
    public Mascota mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        //Se crea un objeto Mascota con los datos del resultSet, que es el resultado de la query
        Region region = new Region();
        region.setId(resultSet.getInt("id_region"));
        region.setNombre(resultSet.getString("nombre_region"));

        //Creo un objeto humano para poder acceder a sus atributos
        Humano humano = new Humano();
        humano.setId(resultSet.getInt("id_humano"));
        humano.setNombre(resultSet.getString("nombre_humano"));

        Mascota mascota = new Mascota();
        mascota.setRegionPokemon(region); //Añado la region como objeto para poder acceder a sus atributos
        mascota.setHumanoMascota(humano); //Añado el dueño como objeto para poder acceder a sus atributos
        mascota.setId(resultSet.getInt("id"));
        mascota.setNombre(resultSet.getString("nombre"));
        mascota.setRegion(resultSet.getInt("id_region"));

        return mascota;
    }


}
