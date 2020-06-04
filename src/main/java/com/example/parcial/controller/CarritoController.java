package com.example.parcial.controller;

import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Productoxcarrito;
import com.example.parcial.repository.CarritoRepository;
import com.example.parcial.repository.ProductoRepository;
import com.example.parcial.repository.ProductoxcarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
