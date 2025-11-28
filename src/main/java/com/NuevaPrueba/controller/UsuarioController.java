package com.NuevaPrueba.controller;

import com.NuevaPrueba.entity.Usuario;
import com.NuevaPrueba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/acceder", method= RequestMethod.POST)
    public String accederUsuario(@RequestParam(name="email")String email, @RequestParam(name="password")String passowrd, Model model) {
        Usuario usuarioActual = usuarioRepository.findByEmailAndPassword(email, passowrd);

        if (usuarioActual == null) {
            model.addAttribute("error", "Usuario no encontrado");
            return "index";
        }

        if ("administrador".equals(usuarioActual.getRol())) {
            return "redirect:/dashboardAdministrador";
        }

        return "redirect:/dashboardCliente";
    }

}