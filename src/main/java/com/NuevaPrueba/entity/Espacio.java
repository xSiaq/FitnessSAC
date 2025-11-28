package com.NuevaPrueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Espacio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_espacio")
    private Long idEspacio;
	
	private String tipo;
	private String nombre;
	private String direccion;
	
	@Column(name="disponibilidad_horaria")
	private String dispoHoraria;
	
	private String estado;

	
	public Long getIdEspacio() {
		return idEspacio;
	}

	public void setIdEspacio(Long idEspacio) {
		this.idEspacio = idEspacio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDispoHoraria() {
		return dispoHoraria;
	}

	public void setDispoHoraria(String dispoHoraria) {
		this.dispoHoraria = dispoHoraria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
