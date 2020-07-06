package com.springboot.web.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
//        return "redirect:/app/index"; //Muestra la ruta a la que se redirijio
        return "forward:/app/index"; //No muestra la ruta a la que redirijio - solo para paginas internas
//        return "redirect:https://www.google.com";
    }
}
