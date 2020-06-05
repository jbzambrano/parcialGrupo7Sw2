package com.example.parcial.controller;


import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Pago;
import com.example.parcial.entity.Usuario;
import com.example.parcial.repository.CarritoRepository;
import com.example.parcial.repository.PagoRepository;
import com.example.parcial.repository.UsuarioRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    PagoRepository pagoRepository;

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
    public String pagarCheckout(@RequestParam("tarjeta") Integer tarjeta,
                                Model model, BindingResult bindingResult,
                                RedirectAttributes attr, Authentication auth,
                                HttpSession session) throws ParseException {

        if (bindingResult.hasErrors()){
            return "registrados/checkout";

        } else{
            int validado = RandomString.validarTarjeta(tarjeta);
            if(validado ==1){
                //Se opera el pago

                Date fecha = new Date();
                SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yyyy");
                String fechaString = fecha.toString();
                Date fechaParseada = parseador.parse(fechaString);

                Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
                Integer dni = usuarioLogueado.getDni();
                Carrito carrito = (Carrito) session.getAttribute("carritoSesion");
                Integer idCar = carrito.getIdcarrito();

                Pago pago = new Pago();
                pago.setFecha(fechaParseada);
                pago.setTarjeta(tarjeta);
                pago.setDni(dni);
                pago.setCarrito(carrito);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);

                int año = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH)+1;
                int dia = calendar.get(Calendar.DAY_OF_MONTH);

                String idPedido= "PE" + dia + mes + año + carrito.getIdcarrito();
                pago.setIdpedido(idPedido);

                pagoRepository.save(pago);
                attr.addFlashAttribute("msg", "Se ha registrado el pago correctamente, disfrute su compra");
                return "redirect:/registrados/checkout";
            } else if (validado == 0) {
                //No se opera el pago
                attr.addFlashAttribute("msg", "Ha ingresado una tarjeta falsa, estamos llamando a la policia");
                return "redirect:/registrados/checkout";
            } else
            {
                attr.addFlashAttribute("msg", "Validación incorrecta");
                return "redirect:/registrados/checkout";
            }

        }

    }


}
