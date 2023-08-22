package com.proyecto.examen.service;

import java.util.List;
import com.proyecto.examen.model.AsignacionExamen;

public interface AsignacionExamenService {

	List<AsignacionExamen> obtenerAsignacionesExamen()throws Exception;
	
	AsignacionExamen obtenerAsignacionExamenById(Integer idAsignacionExamen) throws Exception;
	
	void guardarAsignacionExamen(AsignacionExamen asignacionExamen) throws Exception;
	
	void eliminarAsignacionExamen(Integer idAsignacionExamen) throws Exception;
}
