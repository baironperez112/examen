package com.proyecto.examen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "asignacion_examen")
public class AsignacionExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="estudiante", nullable = false)
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="examen", nullable = false)
	private Examen examen;
	
	@ManyToOne
	@JoinColumn(name="zonaHoraria", nullable = false)
	private ZonaHoraria zonaHoraria;
	
	@ManyToOne
	@JoinColumn(name="fechaPresentacion", nullable = false)
	private FechaPresentacion fechaPresentacion;
	
}
