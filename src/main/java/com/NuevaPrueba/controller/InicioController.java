package com.NuevaPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.NuevaPrueba.entity.Entrenamiento;
import com.NuevaPrueba.repository.EntrenamientoRepository;

@Controller 
public class InicioController {
	@Autowired
	EntrenamientoRepository entrenamientoRepository;

	@GetMapping("/index")
	public String mostrarMenuPrincipal() {
        return "index";
	}

    @GetMapping("/dashboardAdministrador")
    public String mostrarDashboardAdministrador() {
        return "dashboardAdministrador";
    }
    
    @GetMapping("/dashboardCliente")
    public String mostrarDashboardCliente(Model modelo) {
    	List<Entrenamiento> entrenamientos = entrenamientoRepository.findAll();
		modelo.addAttribute("entrenamientos", entrenamientos);
        return "dashboardCliente";
    }
    
}
