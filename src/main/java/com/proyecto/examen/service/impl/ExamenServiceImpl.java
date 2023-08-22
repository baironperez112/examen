package com.proyecto.examen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.examen.model.Examen;
import com.proyecto.examen.model.Pregunta;
import com.proyecto.examen.repository.ExamenRepository;
import com.proyecto.examen.repository.PreguntaRepository;
import com.proyecto.examen.service.ExamenService;

import jakarta.transaction.Transactional;

@Service
public class ExamenServiceImpl implements ExamenService{

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private PreguntaRepository preguntaRepository;

	/**
	 * @throws Exception 
	 * Metodo encargado de obtener el listado de todos los examens
	 */
	@Override
	public List<Examen> obtenerExamenes() throws Exception {
		List <Examen> examenes = new ArrayList<>();
		try {
			examenes = examenRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error al obtener todos los examens");
		}
		return examenes;
	}


	/**
	 * Metodo encargado de obtener el examen por su identificador
	 * @throws Exception 
	 */
	@Override
	public Examen obtenerExamenById(Integer idExamen) throws Exception {
		Examen examen = null;
		if(!examenRepository.existsById(idExamen)) {
			throw new Exception("No existe el examen con id" + idExamen);
		}else {
			examen = examenRepository.findById(idExamen).get();
		}
		return examen;
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de realizar un registri de un examen en la DB
	 */
	@Override
	@Transactional
	public void guardarExamen(Examen examen) throws Exception {
		//Se valida que el examen tenga un puntaje todal de preguntas de 100 pts
		Integer totalPuntosExamen = 0;
		for (int i = 0; i < examen.getPreguntas().size(); i++) {
			Pregunta pregunta = examen.getPreguntas().get(i);
			totalPuntosExamen += pregunta.getPuntaje();
		}
		if(totalPuntosExamen == 100) {
			try {
				//Guardado de examen
				Examen examenRequest = new Examen();
				examenRequest.setNombre(examen.getNombre());
				Examen examenResponse = examenRepository.save(examenRequest);
				
				//Guardado de preguntas
				examen.getPreguntas().forEach(preguntaItem -> {
					Pregunta preguntaRequest = new Pregunta();
					preguntaRequest.setExamen(examenResponse);
					preguntaRequest.setPregunta(preguntaItem.getPregunta());
					preguntaRequest.setOpcion1(preguntaItem.getOpcion1());
					preguntaRequest.setOpcion2(preguntaItem.getOpcion2());
					preguntaRequest.setOpcion3(preguntaItem.getOpcion3());
					preguntaRequest.setOpcion4(preguntaItem.getOpcion4());
					preguntaRequest.setPuntaje(preguntaItem.getPuntaje());
					preguntaRequest.setRespuestaCorrecta(preguntaItem.getRespuestaCorrecta());
					preguntaRepository.save(preguntaRequest);
				});
				
			} catch (Exception e) {
				throw new Exception("Error al guardar el examen");
			}
		} else {
			throw new Exception("La sumatoria de puntos del examen debe ser igual a 100");
		}
		
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de eliminar un examen por su identificador
	 */
	@Override
	public void eliminarExamen(Integer idExamen) throws Exception {
		if(!examenRepository.existsById(idExamen)) {
			throw new Exception("No existe el examen con id" + idExamen);
		}else {
			examenRepository.deleteById(idExamen);
		}
	}

}