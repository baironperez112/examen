package com.proyecto.examen.service;

import java.util.List;

import com.proyecto.examen.model.Estudiante;

public interface EstudianteService {

	List<Estudiante> obtenerEstudiantes()throws Exception;
	
	Estudiante obtenerEstudianteById(Integer idEstudiante) throws Exception;
	
	void guardarEstudiante(Estudiante estudiante) throws Exception;
	
	void eliminarEstudiante(Integer idEstudiante) throws Exception;

}
