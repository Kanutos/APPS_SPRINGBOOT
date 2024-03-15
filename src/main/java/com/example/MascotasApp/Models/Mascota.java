package com.example.MascotasApp.Models;

import lombok.Getter;
import lombok.Setter;

//Creo los getters y setters con lombok
@Getter
@Setter
public class Mascota {
    private int id;
    private String nombre;
    private int region;
    
    //Añado la region como objeto para poder acceder a sus atributos
    private Region regionPokemon; 
    
    //Añado el entrenador como objeto para poder acceder a sus atributos
    private Humano humanoMascota;

    public Mascota(int id, String nombre, int region, Region regionPokemon, Humano humanoMascota) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
        this.regionPokemon = regionPokemon;
        this.humanoMascota = humanoMascota;
        
    }

    public Mascota() {
    }

}
