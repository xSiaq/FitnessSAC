package com.NuevaPrueba.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Entrenamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_entrenamiento")
    private Long idEntrenamiento;
	
	private String tipo;
	private String lugar;
	private Integer duracion;
	
	@Column(name="capacidad_maxima")
	private Integer capacidad;
	
	private LocalDate fecha;
	
	@Column(name="hora_inicio")
	private LocalTime horaInicio;
	@Column(name="hora_fin")
	private LocalTime horaFin;

    private String estado;
	
	@ManyToOne 
	@JoinColumn(name="id_trainer") 
	private Entrenador entrenador;
	
	@ManyToOne 
	@JoinColumn(name="id_espacio") 
	private Espacio espacio;
	

	
	
	public Long getIdEntrenamiento() {
		return idEntrenamiento;
	}

	public void setIdEntrenamiento(Long idEntrenamiento) {
		this.idEntrenamiento = idEntrenamiento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id=" + idEntrenamiento +
                ", entrenador=" + (entrenador != null ? entrenador.getNombres() + " " + entrenador.getApellidos() : "null") +
                '}';
    }

}
