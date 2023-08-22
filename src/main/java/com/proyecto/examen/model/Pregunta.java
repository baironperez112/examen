package com.proyecto.examen.model;

import jakarta.persistence.Column;
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
@Table (name = "pregunta")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="examen", nullable = false)
	private Examen examen;
	
	@Column(name = "pregunta")
	private String pregunta;
	
	@Column(name = "opcion_1")
	private String opcion1;
	
	@Column(name = "opcion_2")
	private String opcion2;
	
	@Column(name = "opcion_3")
	private String opcion3;
	
	@Column(name = "opcion_4")
	private String opcion4;
	
	@Column(name = "respuesta_correcta")
	private String respuestaCorrecta;
	
	@Column(name = "puntaje")
	private Integer puntaje;
}
