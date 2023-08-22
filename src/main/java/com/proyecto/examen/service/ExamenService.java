package com.proyecto.examen.service;

import java.util.List;

import com.proyecto.examen.model.Examen;

public interface ExamenService {

	List<Examen> obtenerExamenes()throws Exception;
	
	Examen obtenerExamenById(Integer idExamen) throws Exception;
	
	void guardarExamen(Examen examen) throws Exception;
	
	void eliminarExamen(Integer idExamen) throws Exception;
}
