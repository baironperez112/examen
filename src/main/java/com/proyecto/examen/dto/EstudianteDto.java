package com.proyecto.examen.dto;

import lombok.Data;

@Data
public class EstudianteDto {

	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String telefono;
	
	private ZonaHorariaDto zonaHoraria;
	
}
