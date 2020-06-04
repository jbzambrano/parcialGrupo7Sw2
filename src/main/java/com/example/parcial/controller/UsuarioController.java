package com.example.parcial.controller;


import com.example.parcial.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {


    @GetMapping("carrito")
    public String irCarrito(){
        return "registrados/carrito";
    }

    @GetMapping("checkout")
    public String irCheckout(){

        return "registrados/checkout";
    }

    @GetMapping("pedidos")
    public String irPedidos(){

        return "registrados/pedidos";
    }

    @PostMapping("pagar")
    public String pagarCheckout(){


        return "redirect:/productos/lista";
    }




}
