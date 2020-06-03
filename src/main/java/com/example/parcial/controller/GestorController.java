package com.example.parcial.controller;

import com.example.parcial.entity.Producto;
import com.example.parcial.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/gestor")
@Controller
public class GestorController {

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(value = {"/list", ""})
    public String listarProductos(Model model) {

        List<Producto> lista = productoRepository.findAll();
        model.addAttribute("productList", lista);

        //session.setAttribute("SaludoRespetuoso","Hola CTM");

        return "gestor/productoList";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(@ModelAttribute("producto") Producto producto,
                                   Model model) {

        //List<Categories> listacatego = categoryRepository.findAll();
        //List<Suppliers> listasuppli = supplierRepository.findAll();

        //model.addAttribute("listacatego",listacatego);
        //model.addAttribute("listasuppli",listasuppli);

        //UsuarioSession usuarioSession = (UsuarioSession) session.getAttribute("usu");

        //System.out.println("El usuario es : " + usuarioSession.getNombre() + " " + usuarioSession.getApellido());


        return "gestor/newFrmProducto";
    }

}