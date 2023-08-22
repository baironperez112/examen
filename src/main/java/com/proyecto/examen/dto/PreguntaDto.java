package com.proyecto.examen.dto;


import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.examen.model.Pregunta;

import lombok.Data;

@Data
public class PreguntaDto {

	private Integer id;
	
	@JsonIgnore
	private ExamenDto examen;

	private String pregunta;
	
	private String opcion1;
	
	private String opcion2;
	
	private String opcion3;
	
	private String opcion4;
	
	private String respuestaCorrecta;
	
	private Integer puntaje;

	public static final Function <Pregunta, PreguntaDto> CONVERT_DTO = (Pregunta preguntaDto)->{
	PreguntaDto preguntaResponse = new PreguntaDto();
	
	preguntaResponse.setId(preguntaDto.getId());
	preguntaResponse.setRespuestaCorrecta(preguntaDto.getRespuestaCorrecta());
	preguntaResponse.setPuntaje(preguntaDto.getPuntaje());
	preguntaResponse.setPregunta(preguntaDto.getPregunta());
	preguntaResponse.setOpcion1(preguntaDto.getOpcion1());
	preguntaResponse.setOpcion2(preguntaDto.getOpcion2());
	preguntaResponse.setOpcion3(preguntaDto.getOpcion3());
	preguntaResponse.setOpcion4(preguntaDto.getOpcion4());
	
	return preguntaResponse;
	};
}
