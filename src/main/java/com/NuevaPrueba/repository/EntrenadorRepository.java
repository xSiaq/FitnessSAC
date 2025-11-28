package com.NuevaPrueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NuevaPrueba.entity.Entrenador;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

	List<Entrenador> findAll();
	Optional<Entrenador> findById(Long id_trainer);

    Entrenador findByNombresContainingIgnoreCase(String nombres);

}
