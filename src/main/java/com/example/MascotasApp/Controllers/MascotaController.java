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
import com.example.MascotasApp.Models.Region;
import com.example.MascotasApp.Repositories.MascotaRepositorio;

@Controller
public class MascotaController {
    
    //Autowired sirve para que se cree una instancia de JdbcTemplate automáticamente.
    // Lo que hace es que el objeto que creas debajo se instancie automáticamente
    @Autowired
    private MascotaRepositorio mascotaRepositorio;

    @Autowired //Lo uso para poder emplear el controlador y obtener una lista de regiones
    private RegionController regionController;

    @Autowired //Lo uso para poder emplear el controlador y obtener una lista de entrenadores
    private HumanoController humanoController;

    @RequestMapping("/formularioMascota")
    public String formInsertadoMascota(Model model){
        Mascota mascota = new Mascota();
        model.addAttribute("mascota", mascota);
        model.addAttribute("listaRegiones", regionController.getTodasRegiones()); //Añadimos la lista de regiones al modelo, para pasarla a la vista
        model.addAttribute("listaHumanos", humanoController.getTodosHumanos()); //Añadimos la lista de entrenadores al modelo, para pasarla a la vista
        return "formMascota"; //Redirige a la página de formMascota.html
    }

    @RequestMapping("/insertarMascota")
    public String insertarMascota(Mascota mascota, @RequestParam int idRegion, @RequestParam int idHumano, Model model){
        Mascota mascotaCreada = new Mascota();
        mascotaCreada.setNombre(mascota.getNombre());
        mascotaCreada.setRegion(idRegion); //Guardo el id de la region en la mascota

        Humano humano = new Humano();
        humano.setId(idHumano);
        mascotaCreada.setHumanoMascota(humano); //Guardo el id del dueño en la mascota
        
        mascotaRepositorio.crearMascota(mascotaCreada); //Creo la mascota    
        return "index"; //Redirige a la página principal
    }

    @RequestMapping("/eliminarMascota")
    public String eliminarMascotaForm(Model model){
        model.addAttribute("listaMascota", mascotaRepositorio.getTodosMascota()); //Paso la lista de todas las mascotas para poder seleccionar cual queremos borrar desde la vista
        return "eliminarMascota"; //Redirige a la página de eliminarMascota.html
    }

    @RequestMapping("/borradoMascota")
    public String eliminarMascota(@RequestParam int idMascota, Model model){
        Mascota mascotaABorrar = new Mascota();
        mascotaABorrar.setId(idMascota);
        mascotaRepositorio.eliminarMascota(mascotaABorrar);
        return "index"; //Redirige a la página principal
    }

    @RequestMapping("/borrarMascotaListadoHumanosActivos/{idMascota}/{idHumano}") //Tengo que hacer otro método porque paso la id de la mascota por la url
    public String eliminarMascotaListadoHumanosActivos(Model model, @PathVariable int idMascota, @PathVariable int idHumano){
        Mascota mascotaABorrar = new Mascota();
        mascotaABorrar.setId(idMascota);

        Humano humano = new Humano(); //Tengo que crear un objeto humano para darle valor y pasarlo a la mascota.
        humano.setId(idHumano); //Le doy el valor de la id del humano que le paso por la url
        humano.setActivo(true); //Le doy el valor de activo a true para que se pueda borrar la mascota

        mascotaABorrar.setHumanoMascota(humano);

        mascotaRepositorio.eliminarMascota(mascotaABorrar);
        return "index"; //Redirige a la página principal
    }


    //Método para obtener toda la lista de mascotas, que uso en el controlador de mascotas para el desplegable de borrado
    public List<Mascota> getTodosMascotas(){
        return mascotaRepositorio.getTodosMascota();
    }
}
