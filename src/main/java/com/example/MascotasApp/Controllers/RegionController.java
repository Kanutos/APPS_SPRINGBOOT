package com.example.MascotasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MascotasApp.Models.Region;
import com.example.MascotasApp.Repositories.RegionRepositorio;

@Controller
public class RegionController {
    
     //Autowire sirve para que se cree una instancia de JdbcTemplate automáticamente. 
    // Lo que hace es que el objeto que creas debajo se instancie automáticamente
    @Autowired
    private  RegionRepositorio regionRepositorio;

    @RequestMapping("/formularioRegion")
    public String formInsertadoRegion(Model model){
        Region region = new Region();
        model.addAttribute("region", region);
        return "formRegion"; //Redirige a la página de formRegion.html
    }

    @RequestMapping("/insertarRegion")
    public String insertarRegion(Region region){
        regionRepositorio.crearRegion(region);
        return "index"; //Redirige a la página principal
    }

    @RequestMapping("/eliminarRegion")
    public String eliminarRegionForm(Model model){
        model.addAttribute("listaRegiones", getTodasRegiones()); //Paso la lista de todas las regiones para poder seleccionar cual queremos borrar desde la vista
        return "eliminarRegion"; //Redirige a la página de eliminarRegion.html
    }

    @RequestMapping("/borradoRegionYMascota")
    public String eliminarRegion(@RequestParam int idRegion, Model model){
        Region regionABorrar = new Region();
        regionABorrar.setId(idRegion);
        
        // Verificar si hay más de una mascota de diferentes dueños en la misma región
        if (regionRepositorio.hayMasDeUnaMascotaEnLaRegion(regionABorrar)) {
            // Operación denegada, informar o manejar según tu necesidad
            model.addAttribute("mensajeError", "No puedes eliminar la región porque hay mascotas de otros dueños en ella.");
            return "error";
        }
        
        regionRepositorio.eliminarRegion(regionABorrar); //Si no hay más de un dueño se sigue con la operación
        return "index"; //Redirige a la página principal
    }



    //Método para obtener todas la lista de las regiones que uso en el controlador de Pokemon para el desplegable del formulario
    public List<Region> getTodasRegiones(){
        return regionRepositorio.getTodasRegiones();
    }


}
