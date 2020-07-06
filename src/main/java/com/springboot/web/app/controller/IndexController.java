package com.springboot.web.app.controller;

import com.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")//base generica para todos
public class IndexController {

    @Value("${text.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${text.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${text.indexcontroller.lista.titulo}")
    private String textoListar;

//    Se retorna un string con el nombre de la vista que se va a cargar
//    A una sola url
//    @GetMapping ("/index")
//    El mismo request para varios urls @GetMapping ({"/index","/","/home"})
    @GetMapping ({"/index","/","","/home"}) //http://localhost:8080/app/index
    public String index(Model model){
        model.addAttribute("titulo", textoIndex);
        //aqui toca crear una plantilla que se llame index.html
        //la cual sera guardada en resources - templates
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil (Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Evelyn");
        usuario.setApellido("Sanchez Agredo");
        usuario.setEmail("evelyn@gmail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar (Model model){
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays
                .asList(new Usuario("Evelyn", "Sanchez Agredo", "evelyn@gmail.com"),
                        new Usuario("Diana", "Benitez", "diana@gmail.com"),
                        new Usuario("JuanDa", "Padilla", "juanda@gmail.com"),
                        new Usuario("Tornado", "Roe", "roe@gmail.com"));
        return usuarios;
    }

}
