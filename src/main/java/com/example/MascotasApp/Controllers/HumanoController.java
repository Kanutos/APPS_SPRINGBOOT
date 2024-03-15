package com.example.MascotasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MascotasApp.Models.Humano;
import com.example.MascotasApp.Models.Mascota;
import com.example.MascotasApp.Repositories.HumanoRepositorio;
import com.example.MascotasApp.Repositories.MascotaRepositorio;


@Controller
public class HumanoController {
    //Autowire sirve para que se cree una instancia de JdbcTemplate automáticamente. 
    // Lo que hace es que el objeto que creas debajo se instancie automáticamente
    @Autowired
    private  HumanoRepositorio humanoRepositorio;

    @Autowired //Lo uso para poder emplear el controlador y obtener una lista de pokemon que tienen los entrenadores activos
    private MascotaRepositorio mascotaRepositorio;

    @RequestMapping("/formularioHumano")
    public String formInsertadoHumano(Model model){
        Humano humano = new Humano();
        model.addAttribute("humano", humano);
        return "formHumano"; //Redirige a la página de formHumano.html
    }

    @RequestMapping("/insertarHumano")
    public String insertarHumano(Humano humano){
        humanoRepositorio.crearHumano(humano);
        return "index"; //Redirige a la página principal
    }

    @RequestMapping("/listarMascotaHumanos")
    public String listarMascotaHumanos(Model model){
        model.addAttribute("listarMascotaHumanosActivos", mascotaRepositorio.getTodosMascotaHumanosActivos()); //Paso la lista de todos las mascotas para poder seleccionar cual queremos borrar desde la vista
        return "listadoMascotaHumano"; //Redirige a la página de listadoMascotaHumano.html
    }

    @RequestMapping("/listarHumanos")
    public String listarHumanos(Model model){
        model.addAttribute("listadoHumanos", humanoRepositorio.getTodosHumanos()); //Paso la lista de todos las mascotas para poder seleccionar cual queremos borrar desde la vista
        return "listadoHumanos"; //Redirige a la página de listarHumanos.html
    }

    @RequestMapping("/cambiarEstadoHumano/{idHumano}")
    public String cambiarEstadoHumano(Model model, @PathVariable int idHumano){
        Humano humano = new Humano();
        humano.setId(idHumano);
        humanoRepositorio.cambiarEstadoHumano(humano);
        return "index"; //Redirige a la página principal
    }

    public List<Humano> getTodosHumanos(){
        return humanoRepositorio.getTodosHumanos();
    }

    public List<Mascota> getTodosHumamosActivos(){
        return mascotaRepositorio.getTodosMascotaHumanosActivos();
    }

    

}
