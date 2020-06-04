package com.example.parcial.controller;


import com.example.parcial.entity.Usuario;
import com.example.parcial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = {"", "/"})
    public String listaGestor(Model model) {
        model.addAttribute("listaGestores", usuarioRepository.listaGestores(2));
        return "admin/listaGestor";
    }

    @GetMapping("/new")
    public String nuevoGestor(@ModelAttribute("usuario") Usuario usuario,
                              Model model) {

        return "admin/form";
    }


    @PostMapping("/save")
    public String guardarGestor(@ModelAttribute("usuario") @Valid Usuario usuario
            , BindingResult bindingResult
            , Model model, RedirectAttributes attr) {

        usuario.setIdrol(2);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(usuario.getDni());
        if (usuario.getDni()==null) {
            model.addAttribute("msgError", "Debe rellenar el parámetro de DNI");
            return "admin/form";
        } else {
            if (bindingResult.hasErrors()) {

                return "admin/form";
            } else {
                Integer dni = usuario.getDni();
                Optional<Usuario> opt = usuarioRepository.findById(dni);
                if (opt.isPresent()) {
                    attr.addFlashAttribute("msg", "Gestor " + "actualizado" + " exitosamente");

                } else {
                    attr.addFlashAttribute("msg", "Gestor " + "creado" + " exitosamente");
                }
                usuarioRepository.save(usuario);
                return "redirect:/admin";
            }
        }

    }

    @GetMapping("/edit")
    public String editarGestor(@ModelAttribute("usuario") Usuario usuario,
                               Model model, @RequestParam("id") int dni) {

        Optional<Usuario> optUsuario = usuarioRepository.findById(dni);
        if (optUsuario.isPresent()) {
            usuario = optUsuario.get();
            model.addAttribute("usuario", usuario);

            return "admin/form";
        } else {
            return "redirect:/admin";
        }
    }

    @GetMapping("/delete")
    public String borrarEmpleado(@RequestParam("id") int dni, RedirectAttributes attr) {
        Optional<Usuario> optional = usuarioRepository.findById(dni);

        if (optional.isPresent()) {
            usuarioRepository.deleteById(dni);
        }
        attr.addFlashAttribute("msg", "usuario borrado exitosamente");
        return "redirect:/admin";
    }


}
