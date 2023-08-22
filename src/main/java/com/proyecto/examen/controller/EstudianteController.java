package com.proyecto.examen.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.examen.dto.EstudianteDto;
import com.proyecto.examen.model.Estudiante;
import com.proyecto.examen.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener todos los estudiantes
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/obtenerEstudiantes")
	public ResponseEntity<List<EstudianteDto>> obtenerEstudiantes() throws Exception{
		List<EstudianteDto> estudiantes = estudianteService.obtenerEstudiantes()
				.stream().map(p -> mapper.map(p, EstudianteDto.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(estudiantes, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener un estudiante por su ID
	 * @param idEstudiante
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<EstudianteDto> obtenerEstudianteById(@PathVariable("id") Integer idEstudiante) throws Exception {
		EstudianteDto estudiante = mapper.map(estudianteService
				.obtenerEstudianteById(idEstudiante), EstudianteDto.class);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer un servicio para guardar un estudiante
	 * @param estudiante
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/guardarEstudiante")
	public ResponseEntity<Boolean> guardarEstudiante(@RequestBody EstudianteDto estudiante) throws Exception {
		estudianteService.guardarEstudiante(mapper.map(estudiante, Estudiante.class));
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de eliminar un estudiante por su identificador
	 * @param idEstudiante
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminarEstudianteById(@PathVariable("id") Integer idEstudiante) throws Exception {
		estudianteService.eliminarEstudiante(idEstudiante);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
}
