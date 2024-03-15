package com.example.MascotasApp.Models;

import lombok.Getter;
import lombok.Setter;

//Creo los getters y setters con lombok
@Getter
@Setter
public class Humano {
    private int id;
    private String nombre;
    private boolean activo;

    public Humano(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Humano() {
    }
}
