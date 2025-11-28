package com.NuevaPrueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NuevaPrueba.entity.Espacio;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Long>{
	
	List<Espacio> findAll();
}
