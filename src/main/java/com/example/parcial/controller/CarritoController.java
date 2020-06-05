package com.example.parcial.controller;

import com.example.parcial.dto.ElementosCarritoPorPedazoDeNombreDto;
import com.example.parcial.dto.ElementosDelCarritoDto;
import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Productoxcarrito;
import com.example.parcial.repository.CarritoRepository;
import com.example.parcial.repository.ProductoRepository;
import com.example.parcial.repository.ProductoxcarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    ProductoxcarritoRepository productoxcarritoRepository;


    @GetMapping("/agregarProducto")
    public String editarTransportista(Model model,
                                      @RequestParam("codigo") String codigo,
                                      RedirectAttributes attr,
                                      HttpSession session) {

        Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
        Integer idCar = carrito.getIdcarrito();


        Productoxcarrito productoxcarrito = new Productoxcarrito();

        productoxcarrito.setCodigo(codigo);
        productoxcarrito.setCantidad(1);
        productoxcarrito.setIdcarrito(idCar);


        Optional<Producto> optionalProducto = productoRepository.findById(codigo);

        Producto prod = optionalProducto.get();



        List<Productoxcarrito> ppc = productoxcarritoRepository.verificarSiYaTengoElProductoEnElCarrito( codigo, idCar);

        if(ppc.size()==0){
            productoxcarritoRepository.save(productoxcarrito);

            attr.addFlashAttribute("msg", "Añadiste "  + prod.getNombre() + " A Tu Carrito");

            return "redirect:/productos/lista";
        }else{
            attr.addFlashAttribute("msgredun", "Este Producto Ya Se Incluyó En Tu Carrito");

            return "redirect:/productos/lista";
        }


    }


    @GetMapping("/lista")
    public String listarCarrito(Model model,
                                RedirectAttributes attr,
                                HttpSession session){

        Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
        Integer idCar = carrito.getIdcarrito();

        List<ElementosDelCarritoDto> elementosDelCarritoDtos = carritoRepository.elementosDelCarritoDto(idCar);

        if(elementosDelCarritoDtos.size()==0){

            attr.addFlashAttribute("msgredun", "Aun No Existen Elementos En Tu Carrito");
            model.addAttribute("elementos", elementosDelCarritoDtos);

            return "registrados/carrito";

        }else{
            model.addAttribute("elementos", elementosDelCarritoDtos);

            return "registrados/carrito";
        }

    }


    @GetMapping("/elementosCarritoPorPedazoDeNombreDto")
    public String elementosCarritoPorPedazoDeNombreDto(Model model,
                                RedirectAttributes attr,@RequestParam("inicio") String inicio,
                                HttpSession session){

        Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
        Integer idCar = carrito.getIdcarrito();

       List<ElementosCarritoPorPedazoDeNombreDto> elementosDelCarritoDtos = carritoRepository.elementosCarritoPorPedazoDeNombreDto(idCar,inicio);

        if(elementosDelCarritoDtos.size()==0){

            attr.addFlashAttribute("msg", "Aun No Existen Elementos En Tu Carrito");

            return "registrados/carrito";

        }else{
            model.addAttribute("elementos", elementosDelCarritoDtos);

            return "registrados/carrito";
        }

    }

    @PostMapping("/agregar")
    public String agregar(Model model, Integer i, String codigo,
                                      RedirectAttributes attr,
                                      HttpSession session) {

        /*
        if(i<1||i>4){
            attr.addFlashAttribute("msgredun", "La Cantidad a Elegir Debe estar entre 1 y 4");

            return "redirect:/productos/lista";

        }else{


            Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
            Integer idCar = carrito.getIdcarrito();

            Productoxcarrito productoxcarrito = new Productoxcarrito();

            productoxcarrito.setCodigo(codigo);
            productoxcarrito.setCantidad(i);
            productoxcarrito.setIdcarrito(idCar);

            Optional<Producto> optionalProducto = productoRepository.findById(codigo);

            Producto prod = optionalProducto.get();

            List<Productoxcarrito> ppc = productoxcarritoRepository.verificarSiYaTengoElProductoEnElCarrito( codigo, idCar);

            if(ppc.size()==0){
                productoxcarritoRepository.save(productoxcarrito);

                attr.addFlashAttribute("msg", "Añadiste "  + prod.getNombre() + " A Tu Carrito");

                return "redirect:/productos/lista";
            }else{
                attr.addFlashAttribute("msgredun", "Este Producto Ya Se Incluyó En Tu Carrito");

                return "redirect:/productos/lista";
            }
        }
        */

        if(i>0&&i<5){
            Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
            Integer idCar = carrito.getIdcarrito();

            Productoxcarrito productoxcarrito = new Productoxcarrito();

            productoxcarrito.setCodigo(codigo);
            productoxcarrito.setCantidad(i);
            productoxcarrito.setIdcarrito(idCar);

            Optional<Producto> optionalProducto = productoRepository.findById(codigo);

            Producto prod = optionalProducto.get();

            List<Productoxcarrito> ppc = productoxcarritoRepository.verificarSiYaTengoElProductoEnElCarrito( codigo, idCar);

            if(ppc.size()==0){
                productoxcarritoRepository.save(productoxcarrito);

                attr.addFlashAttribute("msg", "Añadiste "  + prod.getNombre() + " A Tu Carrito");

                return "redirect:/productos/lista";
            }else{

                attr.addFlashAttribute("msgredun", "Este Producto Ya Se Incluyó En Tu Carrito");

                return "redirect:/productos/lista";
            }

        }else{

            attr.addFlashAttribute("msgredun", "La Cantidad a Elegir Debe estar entre 1 y 4");

            return "redirect:/productos/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrar(Model model, Integer idpxc,
                          RedirectAttributes attr,
                          HttpSession session) {

        productoxcarritoRepository.deleteById(idpxc);
        attr.addFlashAttribute("msg","Elemento Borrado Del Carrito Exitosamente");
        return "redirect:/productos/lista";

    }



}
