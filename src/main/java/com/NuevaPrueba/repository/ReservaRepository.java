package com.NuevaPrueba.repository;

import com.NuevaPrueba.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAll();

    List<Reserva> findByCliente_IdCliente(Long idCliente);

}
