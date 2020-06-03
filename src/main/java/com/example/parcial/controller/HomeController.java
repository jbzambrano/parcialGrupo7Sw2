package com.example.parcial.controller;


import com.example.parcial.entity.Producto;
import com.example.parcial.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@RequestMapping("/productos")
@Controller
public class HomeController {



    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(value = {"", "/listar"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "open/listaProductos";
    }
    //-------------------- Buscador de Productos FERNANDO--------------


    @PostMapping(value ="/buscarProductosPorInicioDeNombreOId")
    public String listaProductosxNombre(@RequestParam("inicio") String inicio,
                                        Model model) {


        List<Producto> listita = productoRepository.buscarProductosPorInicioDeNombreOId(inicio,inicio);

        model.addAttribute("listaProductos",listita);

        return "open/listaProductos";
    }


    //------------------- FIN Buscador de Productos FERNANDO ------------


    //------------------- Detalles de Productos FERNANDO ------------

    @GetMapping("/detalles")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") String id,
                                      RedirectAttributes attr) {

        Optional<Producto> optionalProducto = productoRepository.findById(id);

        Producto producto = optionalProducto.get();

        model.addAttribute("producto",producto);

        return "open/productdetails";

    }

    //------------------- FIN Detalles de Productos FERNANDO ------------





    //-------------------- RECUPERAR CUENTA --------------






    //------------------- FIN RECUPERAR CUENTA ------------

}
