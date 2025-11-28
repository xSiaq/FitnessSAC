package com.NuevaPrueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trainer")
public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_trainer")
    private Long idTrainer;
    
	private String nombres;
	private String apellidos;
	private String especialidad;
	private String correo;
	private String telefono;
    private String estado;
	
	
	public Long getIdTrainer() {
		return idTrainer;
	}
	public void setIdTrainer(Long idTrainer) {
		this.idTrainer = idTrainer;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + idTrainer +
                ", nombre='" + nombres +
                '}';
    }
	
}
