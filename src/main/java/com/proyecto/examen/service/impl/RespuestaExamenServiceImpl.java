package com.proyecto.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.examen.model.Examen;
import com.proyecto.examen.model.Pregunta;
import com.proyecto.examen.model.RespuestaExamen;
import com.proyecto.examen.repository.RespuestaExamenRepository;
import com.proyecto.examen.service.ExamenService;
import com.proyecto.examen.service.RespuestaExamenService;

@Service
public class RespuestaExamenServiceImpl implements RespuestaExamenService{

	@Autowired
	private RespuestaExamenRepository respuestaExamenRepository;

	@Autowired
	private ExamenService examenService;
	
	

	/**
	 * @throws Exception 
	 * Metodo encargado de obtener el listado de todos los respuestaExamens
	 */
	@Override
	public List<RespuestaExamen> obtenerRespuestasExamen() throws Exception {
		List<RespuestaExamen> respuestaExamens = null;
		try {
			respuestaExamens = respuestaExamenRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error al obtener todos las respuestaExamens");
		}
		return respuestaExamens;
	}


	/**
	 * Metodo encargado de obtener el respuestaExamen por su identificador
	 * @throws Exception 
	 */
	@Override
	public RespuestaExamen obtenerRespuestaExamenById(Integer idRespuestaExamen) throws Exception {
		RespuestaExamen respuestaExamen = null;
		if(!respuestaExamenRepository.existsById(idRespuestaExamen)) {
			throw new Exception("No existe el respuestaExamen con id" + idRespuestaExamen);
		}else {
			respuestaExamen = respuestaExamenRepository.findById(idRespuestaExamen).get();
		}
		return respuestaExamen;
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de realizar un registri de un respuestaExamen en la DB
	 */
	@Override
	public RespuestaExamen guardarRespuestaExamen(RespuestaExamen respuestaExamen) throws Exception {
		Integer resultado = 0;
		String respuestasEstudiante = "";
		Examen examen = examenService.obtenerExamenById(respuestaExamen.getExamen().getId());
			
		for (int i = 0; i < examen.getPreguntas().size(); i++) {
			Pregunta pregunta = examen.getPreguntas().get(i);
			String respuesta = respuestaExamen.getMapRespuestas().get(pregunta.getId());
			respuestasEstudiante += "pregunta " + pregunta.getId() + " = " + respuesta + " | ";
			if(respuesta != null) {
				if(pregunta.getRespuestaCorrecta().equals(respuesta)) {
					resultado += pregunta.getPuntaje();
				}
			}
		}
		respuestaExamen.setRespuestas(respuestasEstudiante);
		respuestaExamen.setCalificacion(resultado);
		respuestaExamenRepository.save(respuestaExamen);
		
		return respuestaExamen;
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de eliminar un respuestaExamen por su identificador
	 */
	@Override
	public void eliminarRespuestaExamen(Integer idRespuestaExamen) throws Exception {
		if(!respuestaExamenRepository.existsById(idRespuestaExamen)) {
			throw new Exception("No existe el respuestaExamen con id" + idRespuestaExamen);
		}else {
			respuestaExamenRepository.deleteById(idRespuestaExamen);
		}
	}

}
