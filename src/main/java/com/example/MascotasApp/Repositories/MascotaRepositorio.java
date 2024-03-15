package com.example.MascotasApp.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MascotasApp.Models.Mascota;
import com.example.MascotasApp.Models.Region;

@Repository //Indica que es un repositorio
public class MascotaRepositorio {
    
    //Autowired sirve para que se cree una instancia de JdbcTemplate automáticamente
    //JdbcTemplate sirve para hacer consultas a la base de datos
    //HAY QUE PONER SIEMPRE EL jdbcTemplate SIEMPREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Mascota> getTodosMascota(){ //Devuelve una lista de Mascotas con todos los datos y con la informacion de la region y el dueño. Esto es para luego guardarlo en el rowMapper
        String query = "SELECT m.*, r.id as id_region, r.nombre as nombre_region, h.id as id_humano, h.nombre as nombre_humano FROM mascota as m, region as r, humano as h WHERE m.region = r.id AND h.id = m.humano_id";
        List<Mascota> listaMascota = jdbcTemplate.query(query, new MascotaRowMapper());
        //Se hace la query y se le pasa el RowMapper para que sepa como mapear los datos
        return listaMascota;
    }

    public void crearMascota(Mascota mascota){ //Crea una mascota con su id, nombre y region
        String query = "INSERT INTO mascota (nombre, region, humano_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(query,mascota.getNombre(), mascota.getRegion(), mascota.getHumanoMascota().getId());
    }

    public void eliminarMascota(Mascota mascota){ //Elimina una mascota de la BDD
        //Sistema de control para que no se puedan borrar mascota si su dueño no quiere adoptar y no esta activo
        if(mascota.getHumanoMascota() != null && mascota.getHumanoMascota().isActivo()){ 
            String query = "DELETE FROM mascota WHERE id = ?";
            jdbcTemplate.update(query, mascota.getId());
        }
    }

    public List<Mascota> getTodosMascotaHumanosActivos(){ //Devuelve una lista de pokemon con todos los datos y con la informacion de la region y el entrenador. Esto es para luego guardarlo en el rowMapper
        String query = "SELECT m.*, r.id as id_region, r.nombre as nombre_region, h.id as id_humano, h.nombre as nombre_humano FROM mascota as m, region as r, humano as h WHERE m.region = r.id AND h.id = m.humano_id AND h.activo = true";
        List<Mascota> listaMascota = jdbcTemplate.query(query, new MascotaRowMapper());
        //Se hace la query y se le pasa el RowMapper para que sepa como mapear los datos
        return listaMascota;
    }

}
