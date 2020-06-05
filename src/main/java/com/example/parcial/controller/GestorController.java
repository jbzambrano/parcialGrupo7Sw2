package com.example.parcial.controller;

import com.example.parcial.entity.Producto;
import com.example.parcial.repository.CarritoRepository;
import com.example.parcial.repository.PagoRepository;
import com.example.parcial.repository.ProductoRepository;
import com.example.parcial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/gestor")
@Controller
public class GestorController {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PagoRepository pagoRepository;

    @GetMapping(value = {"/list", ""})
    public String listarProductos(Model model) {

        List<Producto> lista = productoRepository.findAll();
        model.addAttribute("productList", lista);

        //session.setAttribute("SaludoRespetuoso","Hola CTM");

        return "gestor/productoList";
    }

    @GetMapping("/newProduct")
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

    @PostMapping("/saveProduct")
    public String guardarNuevoProducto(@ModelAttribute("producto") @Valid Producto producto,
                                       BindingResult bindingResult,
                                       RedirectAttributes attr, Model model) {


        if (bindingResult.hasErrors()) {

            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

            System.out.println("este es el codigo" + producto.getCodigo());

            return "gestor/newFrmProducto";

        } else {

            Optional<Producto> optionalProducto = productoRepository.findById(producto.getCodigo());
            if(optionalProducto.isPresent()){

                model.addAttribute("errorCompany", "Este codigo ya existe");
                return "gestor/newFrmProducto";
            }else{
                attr.addFlashAttribute("msg", "Producto Creado Exitosamente");

                productoRepository.save(producto);

                return "redirect:/gestor/list";
            }

        }

    }

    @PostMapping("/saveProductEdit")
    public String guardarNuevoProduct(@ModelAttribute("producto") @Valid Producto producto,
                                       BindingResult bindingResult,
                                       RedirectAttributes attr, Model model) {


        if (bindingResult.hasErrors()) {


            return "gestor/editFrmProducto";

        } else {

            attr.addFlashAttribute("msg", "Producto Actualizado Exitosamente");

            productoRepository.save(producto);


            return "redirect:/gestor/list";
        }

    }

    @GetMapping("/editProducto")
    public String editarTransportista(@ModelAttribute("producto") Producto producto,
                                      Model model,
                                      @RequestParam("id") String id) {

        Optional<Producto> optionalProducts = productoRepository.findById(id);

        //List<Region> listareg = regionRepository.findAll();
        //List<Suppliers> listasuppli = supplierRepository.findAll();

        //List<Categories> listacatego = categoryRepository.findAll();
        //List<Suppliers> listasuppli = supplierRepository.findAll();

        if (optionalProducts.isPresent()) {

            producto = optionalProducts.get();

            //model.addAttribute("listareg",listareg);
            model.addAttribute("producto", producto);
            //model.addAttribute("listacatego",listacatego);
            //model.addAttribute("listasuppli",listasuppli);

            return "gestor/editFrmProducto";
        } else {
            return "redirect:/gestor/list";
        }
    }

    @GetMapping("/estadistica1")
    public String estadistica1(Model model){
        model.addAttribute("cantidadComprasRealizadas", pagoRepository.cantidadComprasRealizadas());
        return "estadisticas/cantidadCompras";
    }

    @GetMapping("/estadistica2")
    public String estadistica2(Model model){
        model.addAttribute("totalFacturado", carritoRepository.totalFacturado());
        return "estadisticas/totalFacturado";
    }

    @GetMapping("/estadistica3")
    public String estadistica3(Model model){
        model.addAttribute("cantidadProductosVendidos", productoRepository.cantiProductosVend());
        return "estadisticas/cantidadProductosVendidos";
    }

    @GetMapping("/estadistica4")
    public String estadistica4(Model model){
        model.addAttribute("productoMasVendido", productoRepository.productMasVendido());
        return "estadisticas/productoMasVendido";
    }

    @GetMapping("/estadistica5")
    public String estadistica5(Model model){
        model.addAttribute("productoMenosVendido", productoRepository.productMenosVendido());
        return "estadisticas/productoMenosVendido";
    }

    @GetMapping("/estadistica6")
    public String estadistica6(Model model){
        model.addAttribute("productoMasCaro", productoRepository.productMasCaro());
        return "estadisticas/productoMasCaro";
    }

    /*
    @GetMapping("/estadistica7")
    public String estadistica7(Model model){
        model.addAttribute("usuarioMasGastador", usuarioRepository.AUNNOHAYQUEY());
        return "estadisticas/cantidadCompras";
    }
    */

    @GetMapping("/olig")
    public String estadistica7(Model model){
        model.addAttribute("olig", usuarioRepository.usuarioOligarcaDto());
        return "estadisticas/masolig";
    }





}
