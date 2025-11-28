package com.NuevaPrueba.controller;

import com.NuevaPrueba.entity.Entrenador;
import com.NuevaPrueba.entity.Entrenamiento;
import com.NuevaPrueba.entity.Espacio;
import com.NuevaPrueba.entity.Reserva;
import com.NuevaPrueba.repository.ClienteRepository;
import com.NuevaPrueba.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("vistaReserva")
    private String mostrarVistaReserva(Model model) {
        List<Reserva> listaReservas = reservaRepository.findAll();
        model.addAttribute("listaReservas", listaReservas);
        return "reserva/vistaReserva";
    }

    @RequestMapping(value="/buscar", method = RequestMethod.POST)
    private String buscarReserva(@RequestParam("clienteBusqueda")String clienteBusqueda, Model model) {
        List<Reserva> resultados;

        System.out.println("clienteBusqueda: " + clienteBusqueda);

        if (clienteBusqueda.trim().isEmpty()) {
            resultados = reservaRepository.findAll();
            model.addAttribute("listaReservas", resultados);
            return "/reserva/vistaReserva";
        }

        var optCliente = clienteRepository.findByNombresContainingIgnoringCase(clienteBusqueda);

        var reservas = reservaRepository.findByCliente_IdCliente(optCliente.getIdCliente());

        if (reservas.isEmpty()) {
            model.addAttribute("mensaje", "El cliente buscado no contiene reservas realizadas o no existe");
        }

        System.out.println(reservas);

        model.addAttribute("placeholder", clienteBusqueda);
        model.addAttribute("listaReservas", reservas);
        return "/reserva/vistaReserva";
    }

}
