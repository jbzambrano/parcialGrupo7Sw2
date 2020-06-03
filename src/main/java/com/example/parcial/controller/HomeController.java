package com.example.parcial.controller;


import com.example.parcial.entity.Usuario;
import com.example.parcial.repository.ProductoRepository;
import com.example.parcial.repository.UsuarioRepository;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;


@RequestMapping("/productos")
@Controller
public class HomeController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaProductos", productoRepository.findAll());
        return "open/listaProductos";
    }


    //-------------------- RECUPERAR CUENTA --------------


    @GetMapping("recuperarContraseña")
    public String recuperarContraseña(@RequestParam("correo") String correo, @ModelAttribute("usuario") Usuario usuario,
                                      Model model, BindingResult bindingResult,
                                      RedirectAttributes attr){

        List<Usuario> usuarioCorreo = usuarioRepository.obtenerCorreo(correo);

        if (usuarioCorreo.size()!=0){
            //Se envie correo

            /*
            try {
                HtmlEmail email = new HtmlEmail();
                String ipAdd = InetAddress.getLocalHost().getHostAddress();
                int localPort = request.getLocalPort();
                String context = request.getContextPath();

            } catch (Exception e) {
                out.println(e);
            }

            PrintWriter out = response.getWriter();
            response.setContentType("text/hml");
            request.setAttribute("msg_error", null);

            if (participador.getCodigo() != null) {
                System.out.println("entro a 1");
                String hash = participanteDao.insertarHash(participador);

                request.setAttribute("hasheado", hash);

                try {

                    String ipAdd = InetAddress.getLocalHost().getHostAddress();
                    //request.setAttribute("ip", ipAdd);
                    //String ipAdd = request.getRequestURL().toString();
                    int localPort = request.getLocalPort();
                    String context = request.getContextPath();
                    Email email = new Email();
                    email.sendEmail(corr, hash, ipAdd, localPort, context);
                    request.setAttribute("msg_error", "mensaje enviado");
                } catch (Exception e) {
                    out.println(e);
                }
                view = request.getRequestDispatcher("General/G-ConfirmarRecuperar.jsp");
                view.forward(request, response);
            } else {
                System.out.println("no entro");
                request.setAttribute("msg_error", "Correo inexistente en la base de datos");
                view = request.getRequestDispatcher("General/G-RecuperarContraseña.jsp");
                view.forward(request, response);
            }
            break;
             */

            attr.addFlashAttribute("msgError","Se le ha enviado a su correo una nueva contraseña");
        } else {
            attr.addFlashAttribute("msgError","El correo no existe en la base de datos");
        }

        return "open/recuperarContra";
    }

    @GetMapping("registrarUsuario")
    public String crearUsuaeio(){


        return "open/registroRegistrado";
    }


    //------------------- FIN RECUPERAR CUENTA ------------

}
