package com.NuevaPrueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NuevaPrueba.entity.Entrenamiento;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrenamientoRepository  extends JpaRepository<Entrenamiento, Long>{

	List<Entrenamiento> findAll();
	Optional<Entrenamiento> findById(Long id_entrenamiento);

    @Transactional
    void deleteById(Long id);

    List<Entrenamiento> findByEntrenador_IdTrainer(Long idTrainer);

}
