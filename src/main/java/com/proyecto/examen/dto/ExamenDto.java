package com.proyecto.examen.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.proyecto.examen.model.Examen;
import lombok.Data;

@Data
public class ExamenDto {

	private Integer id;
	
	private String nombre;
	
	private List<PreguntaDto> preguntas;
	
	
	public static final Function <Examen, ExamenDto> CONVERT_DTO = (Examen examen) -> {
		
		ExamenDto examenResponse = new ExamenDto();
		List<PreguntaDto> preguntaDto = new ArrayList<>();
		examen.getPreguntas().forEach(item -> {
		preguntaDto.add(PreguntaDto.CONVERT_DTO.apply(item));
		examenResponse.setPreguntas(preguntaDto);
		examenResponse.setNombre(examen.getNombre());
		examenResponse.setId(examen.getId());
		});
		return examenResponse;
		
	};
}
