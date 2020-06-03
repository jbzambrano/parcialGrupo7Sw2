package com.example.parcial.controller;


import com.example.parcial.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/productos")
@Controller
public class HomeController {



    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "open/listaProductos";
    }


    //-------------------- REGISTRO Y RECUPERAR CUENTA --------------

    @GetMapping(value="/loginForm")
    public String loginForm(){

        return "open/index";
    }





    //------------------- FIN REGISTRO Y RECUPERAR CUENTA ------------

}
