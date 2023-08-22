package com.proyecto.examen.model;

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table (name = "respuesta_examen")
public class RespuestaExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="estudiante", nullable = false)
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="examen", nullable = false)
	private Examen examen;
	
	@Column(name = "respuestas")
	private String respuestas;
	
	@Column(name = "calificacion")
	private Integer calificacion;
	
	@Transient
	private Map<Integer, String> mapRespuestas;
	
}
