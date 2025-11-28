package com.NuevaPrueba.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.NuevaPrueba.entity.Entrenador;
import com.NuevaPrueba.repository.EntrenadorRepository;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {

	@Autowired
	EntrenadorRepository entrenadorRepository;
	
	@GetMapping("/vistaEntrenadores")
	public String mostrarVistaEntrenador(Model modelo) {
		List<Entrenador> listaEntrenadores = entrenadorRepository.findAll();
		modelo.addAttribute("listaEntrenadores", listaEntrenadores);
		modelo.addAttribute("nuevoEntrenador", new Entrenador());
		return "entrenador/vistaEntrenadores";
	}
	
	@PostMapping("/registrar")
	public String registrarNuevoEntrenador(@ModelAttribute("nuevoEntrenador")Entrenador entrenador) {
		entrenadorRepository.save(entrenador);
		return "redirect:/entrenador/vistaEntrenadores";
	}
	
	@GetMapping("/actualizar/{id}")
	public String mostrarActualizarEntrenador(@PathVariable("id") Long id, Model model) {
		Entrenador entrenador = entrenadorRepository.findById(id).orElse(null);
		model.addAttribute("entrenador", entrenador);
		return "entrenador/actualizarEntrenador";
	}
	
	@PostMapping("/actualizar")
	public String editarEntrenador(@ModelAttribute("entrenador") Entrenador entrenador) {
	    entrenadorRepository.save(entrenador);
	    return "redirect:/entrenador/vistaEntrenadores";
	}
	
	@GetMapping("/cambiarEstado/{id}")
    public String cambiarEstadoEntrenador(@PathVariable("id") Long id, Model model) {
        Entrenador entrenador = entrenadorRepository.findById(id).orElse(null);
        if (entrenador != null) {
            if ("activo".equalsIgnoreCase(entrenador.getEstado())) {
                entrenador.setEstado("inactivo");
            } else {
                entrenador.setEstado("activo");
            }
            entrenadorRepository.save(entrenador);
        }
        return "redirect:/entrenador/vistaEntrenadores";
    }
	
}
