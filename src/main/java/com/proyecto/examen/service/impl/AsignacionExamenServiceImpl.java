package com.proyecto.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.examen.model.AsignacionExamen;
import com.proyecto.examen.repository.AsignacionExamenRepository;
import com.proyecto.examen.service.AsignacionExamenService;

@Service
public class AsignacionExamenServiceImpl implements AsignacionExamenService{

	@Autowired
	private AsignacionExamenRepository asignacionExamenRepository;


	/**
	 * @throws Exception 
	 * Metodo encargado de obtener el listado de todos las asignaciones
	 */
	@Override
	public List<AsignacionExamen> obtenerAsignacionesExamen() throws Exception {
		List<AsignacionExamen> asignacionExamens = null;
		try {
			asignacionExamens = asignacionExamenRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error al obtener todos los asignacionExamens");
		}
		return asignacionExamens;
	}


	/**
	 * Metodo encargado de obtener la asignación por su identificador
	 * @throws Exception 
	 */
	@Override
	public AsignacionExamen obtenerAsignacionExamenById(Integer idAsignacionExamen) throws Exception {
		AsignacionExamen asignacionExamen = null;
		if(!asignacionExamenRepository.existsById(idAsignacionExamen)) {
			throw new Exception("No existe el asignacionExamen con id" + idAsignacionExamen);
		}else {
			asignacionExamen = asignacionExamenRepository.findById(idAsignacionExamen).get();
		}
		return asignacionExamen;
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de realizar un registro de un asignacion en la DB
	 */
	@Override
	public void guardarAsignacionExamen(AsignacionExamen asignacionExamen) throws Exception {
		try {
			asignacionExamenRepository.save(asignacionExamen);
		} catch (Exception e) {
			throw new Exception("Error al guardar el asignacionExamen");
		}
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de eliminar una asignacion por su identificador
	 */
	@Override
	public void eliminarAsignacionExamen(Integer idAsignacionExamen) throws Exception {
		if(!asignacionExamenRepository.existsById(idAsignacionExamen)) {
			throw new Exception("No existe el asignacionExamen con id" + idAsignacionExamen);
		}else {
			asignacionExamenRepository.deleteById(idAsignacionExamen);
		}
	}

}
