package com.example.parcial.controller;

import com.example.parcial.controller.RandomString;
import com.example.parcial.entity.Usuario;
import com.example.parcial.repository.ProductoRepository;
import com.example.parcial.repository.UsuarioRepository;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


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


    @PostMapping("guardarNuevaContraseña")
    public String guardarNuevaContraseña(@RequestParam("correo") String correo, @ModelAttribute("usuario") Usuario usuario,
                                      Model model, BindingResult bindingResult,
                                      RedirectAttributes attr){

        List<Usuario> usuarioCorreo = usuarioRepository.obtenerCorreo(correo);
        if(bindingResult.hasErrors()) {
            return "open/recuperarContra";
        }
        else {

            if (usuarioCorreo.size() != 0) {
                //Se envie correo
                String from = "a20150875@pucp.edu.pe";
                String host = "smtp.test.com";

                Properties properties = new Properties();
                properties.setProperty("mail.smtp.host", host);
                Session session = Session.getDefaultInstance(properties);

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
                    message.setSubject("Nueva Contraseña");
                    //Genera la contraseña de 8 letras y 2 numeros
                    String nuevaContra = RandomString.getStringLetras(8) + RandomString.getStringNumeros(2);
                    message.setText("Su nueva contraseña es: " + nuevaContra);
                    //Aqui deberia setear su nueva contraseña
                    String passwordhash = BCrypt.hashpw(nuevaContra, BCrypt.gensalt());
                    usuario.setPassword(passwordhash);
                    Transport.send(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                attr.addFlashAttribute("msg", "Se le ha enviado a su correo una nueva contraseña");
                return "redirect:/productos/recuperarContra";
            } else {
                attr.addFlashAttribute("msg", "El correo no existe en la base de datos");
                return "redirect:/productos/recuperarContra";
            }
        }

    }

    @GetMapping("recuperarContra")
    public String recuperarContra(@ModelAttribute("usuario") Usuario usuario, HttpSession session){
        Usuario u = (Usuario) session.getAttribute("user");

        return "open/recuperarContra";
    }

    @GetMapping("registrarUsuario")
    public String creaRegistrado(@ModelAttribute("usuario") Usuario usuario,
                                 Model model){

        return "open/registroRegistrado";

    }


    @PostMapping("guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuario") @Valid Usuario usuario,BindingResult bindingResult,
                                 Model model, RedirectAttributes attr){

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getDni());
        if (optionalUsuario.isPresent()){
            model.addAttribute("msg", "Este usuario es invalido");
            return "open/registroRegistrado";
        } else {

            if (usuario.getDni()==null) {
                model.addAttribute("msg", "Debe rellenar el parámetro de DNI");
                return "open/registroRegistrado";
            } else {

                if (bindingResult.hasErrors()) {
                    //System.out.println("hola");
                    return "open/registroRegistrado";
                } else {
                    usuarioRepository.guardarRegistrados(usuario.getDni(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getPassword());
                    System.out.println(usuario.getDni());
                    return "redirect:/open/listaProductos";
                }
            }
        }
    }

    //------------------- FIN RECUPERAR CUENTA ------------

}