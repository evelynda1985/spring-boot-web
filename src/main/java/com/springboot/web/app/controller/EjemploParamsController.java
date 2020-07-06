package com.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(@RequestParam(name="texto", required=false, defaultValue = "algun valor") String texto, Model model){
        model.addAttribute("resultado", "El texto enviado es " + texto);
        return "params/index";//retorna una vista dentro del directorio params
    }


    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required=false, defaultValue = "algun valor") String texto, Model model){
        model.addAttribute("resultado", "El texto enviado es " + texto);
        return "params/ver";
    }

    //Mejor usar este approach, mas moderno, mejor y menos codigo en vez de HttpServletRequest
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado", "El texto saludo es: '" + saludo + "' y el numero es '" + numero + "'");
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try{
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e){
            numero= 0;
        }
        model.addAttribute("resultado", "El texto saludo es: '" + saludo + "' y el numero es '" + numero + "'");
        return "params/ver";
    }

}
