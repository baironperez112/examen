package com.proyecto.examen.dto;

import java.util.Map;

import lombok.Data;

@Data
public class RespuestaExamenDto {

	private Integer id;
	
	private EstudianteDto estudiante;
	
	private ExamenDto examen;
	
	private String respuestas;
	
	private Integer calificacion;
	
	private Map<Integer, String> mapRespuestas;
	
}
