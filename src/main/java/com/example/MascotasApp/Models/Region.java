package com.example.MascotasApp.Models;

import lombok.Getter;
import lombok.Setter;

//Creo los getters y setters con lombok
@Getter
@Setter
public class Region {
    
    private int id;
    private String nombre;

    public Region(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Region() {
    }
}
