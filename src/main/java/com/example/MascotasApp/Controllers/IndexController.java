package com.example.MascotasApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/") // Si ponemos en la URL localhost:8080/ se ejecuta la función y nos redirige a index.html
    public String inicio(){

        return "index"; //Nos redirige a la página de index.html
    }

}

