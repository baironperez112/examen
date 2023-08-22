package com.proyecto.examen.dto;

import lombok.Data;

@Data
public class AsignacionExamenDto {

	private Integer id;
	
	private EstudianteDto estudiante;
	
	private ExamenDto examen;
	
	private ZonaHorariaDto zonaHoraria;
	
	private FechaPresentacionDto fechaPresentacion;
	
}
