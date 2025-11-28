package com.NuevaPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.NuevaPrueba.entity.Entrenador;
import com.NuevaPrueba.entity.Entrenamiento;
import com.NuevaPrueba.entity.Espacio;
import com.NuevaPrueba.repository.EntrenadorRepository;
import com.NuevaPrueba.repository.EntrenamientoRepository;
import com.NuevaPrueba.repository.EspacioRepository;


@Controller
@RequestMapping("/entrenamiento")
public class EntrenamientoController {
	
	@Autowired
	EntrenamientoRepository entrenamientoRepository;
	
	@Autowired
    private EntrenadorRepository entrenadorRepository;
	
	@Autowired
    private EspacioRepository espacioRepository;
	
	@GetMapping("/vistaEntrenamiento")
	public String mostrarVistaEntrenamiento(Model modelo) {
		List<Entrenamiento> listaEntrenamientos = entrenamientoRepository.findAll();
		modelo.addAttribute("listaEntrenamientos", listaEntrenamientos);
		
		modelo.addAttribute("nuevoEntrenamiento", new Entrenamiento());
		List<Entrenador> listaEntrenadores = entrenadorRepository.findAll();
		modelo.addAttribute("listaEntrenadores", listaEntrenadores);
		List<Espacio> listaEspacio = espacioRepository.findAll();
		modelo.addAttribute("listaEspacio", listaEspacio);
		return "entrenamiento/vistaEntrenamiento";
	}
	
	@PostMapping("/registrar")
	public String registrarNuevoEntrenamiento(@ModelAttribute("nuevoEntrenamiento")Entrenamiento entrenamiento) {
		entrenamientoRepository.save(entrenamiento);
		return "redirect:/entrenamiento/vistaEntrenamiento";
	}
	
	@GetMapping("/actualizar/{id}")
	public String mostrarActualizarEntrenamiento(@PathVariable("id") Long id, Model model) {
		Entrenamiento entrenamiento = entrenamientoRepository.findById(id).orElse(null);
		model.addAttribute("entrenamiento", entrenamiento);
		
		List<Entrenador> listaEntrenadores = entrenadorRepository.findAll();
		model.addAttribute("listaEntrenadores", listaEntrenadores);
	    List<Espacio> listaEspacio = espacioRepository.findAll();
	    model.addAttribute("listaEspacio", listaEspacio);
		return "entrenamiento/actualizarEntrenamiento";
	}
	
	@PostMapping("/actualizar")
	public String editarEntrenamiento(@ModelAttribute("entrenamiento") Entrenamiento entrenamiento) {
	    entrenamientoRepository.save(entrenamiento);
	    return "redirect:/entrenamiento/vistaEntrenamiento";
	}
	
	@GetMapping("/eliminar/{id}")
    public String eliminarEntrenamiento(@PathVariable("id") Long id) {
        entrenamientoRepository.deleteById(id);
        return "redirect:/entrenamiento/vistaEntrenamiento";
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public String buscarEntrenamiento(@RequestParam("entrenadorBusqueda")String entrenadorBusqueda, Model model) {
        List<Entrenamiento> resultados;

        if (entrenadorBusqueda.trim().isEmpty()) {
            resultados = entrenamientoRepository.findAll();
            model.addAttribute("entrenamientos", resultados);
            return "dashboardCliente";
        }

        var optEntrenador = entrenadorRepository.findByNombresContainingIgnoreCase(entrenadorBusqueda);

        var entrenamientos = entrenamientoRepository.findByEntrenador_IdTrainer(optEntrenador.getIdTrainer());

        System.out.println("entrenamientos: " + entrenamientos.toString());

        if (entrenamientos.isEmpty()) {
            model.addAttribute("mensaje", "El entrenador buscado no contiene entrenamientos disponibles o no existe");
        }

        model.addAttribute("placeholder", entrenadorBusqueda);
        model.addAttribute("entrenamientos", entrenamientos);
        return "dashboardCliente";

    }

}
