package com.proyecto.examen.service;

import java.util.List;

import com.proyecto.examen.model.RespuestaExamen;

public interface RespuestaExamenService {

	List<RespuestaExamen> obtenerRespuestasExamen()throws Exception;
	
	RespuestaExamen obtenerRespuestaExamenById(Integer idExamen) throws Exception;
	
	RespuestaExamen guardarRespuestaExamen(RespuestaExamen respuestaExamen) throws Exception;
	
	void eliminarRespuestaExamen(Integer idRespuestaExamen) throws Exception;
}
