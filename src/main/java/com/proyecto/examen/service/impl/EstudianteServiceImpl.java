package com.proyecto.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.examen.model.Estudiante;
import com.proyecto.examen.repository.EstudianteRepository;
import com.proyecto.examen.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;


	/**
	 * @throws Exception 
	 * Metodo encargado de obtener el listado de todos los estudiantes
	 */
	@Override
	public List<Estudiante> obtenerEstudiantes() throws Exception {
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error al obtener todos los estudiantes");
		}
		return estudiantes;
	}


	/**
	 * Metodo encargado de obtener el estudiante por su identificador
	 * @throws Exception 
	 */
	@Override
	public Estudiante obtenerEstudianteById(Integer idEstudiante) throws Exception {
		Estudiante estudiante = null;
		if(!estudianteRepository.existsById(idEstudiante)) {
			throw new Exception("No existe el estudiante con id" + idEstudiante);
		}else {
			estudiante = estudianteRepository.findById(idEstudiante).get();
		}
		return estudiante;
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de realizar un registri de un estudiante en la DB
	 */
	@Override
	public void guardarEstudiante(Estudiante estudiante) throws Exception {
		try {
			estudianteRepository.save(estudiante);
		} catch (Exception e) {
			throw new Exception("Error al guardar el estudiante");
		}
	}


	/**
	 * @throws Exception 
	 * Metodo encargado de eliminar un estudiante por su identificador
	 */
	@Override
	public void eliminarEstudiante(Integer idEstudiante) throws Exception {
		if(!estudianteRepository.existsById(idEstudiante)) {
			throw new Exception("No existe el estudiante con id" + idEstudiante);
		}else {
			estudianteRepository.deleteById(idEstudiante);
		}
	}

}
