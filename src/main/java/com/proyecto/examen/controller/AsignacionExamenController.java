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

import com.proyecto.examen.dto.AsignacionExamenDto;
import com.proyecto.examen.model.AsignacionExamen;
import com.proyecto.examen.service.AsignacionExamenService;

@RestController
@RequestMapping("/asignacionExamen")
public class AsignacionExamenController {

	@Autowired
	private AsignacionExamenService asignacionExamenService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener todos las asignacionExamens jjjj
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/obtenerAsignacionesExamen")
	public ResponseEntity<List<AsignacionExamenDto>> obtenerAsignacionExamens() throws Exception{
		List<AsignacionExamenDto> asignacionExamens = asignacionExamenService.obtenerAsignacionesExamen()
				.stream().map(p -> mapper.map(p, AsignacionExamenDto.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(asignacionExamens, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener una asignacionExamen por su ID
	 * @param idAsignacionExamen
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<AsignacionExamenDto> obtenerAsignacionExamenById(@PathVariable Integer idAsignacionExamen) throws Exception {
		AsignacionExamenDto asignacionExamen = mapper.map(asignacionExamenService
				.obtenerAsignacionExamenById(idAsignacionExamen), AsignacionExamenDto.class);
		return new ResponseEntity<>(asignacionExamen, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer un servicio para guardar una asignacionExamen
	 * @param asignacionExamen
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/guardarAsignacionExamen")
	public ResponseEntity<Boolean> guardarAsignacionExamen(@RequestBody AsignacionExamenDto asignacionExamen) throws Exception {
		asignacionExamenService.guardarAsignacionExamen(mapper.map(asignacionExamen, AsignacionExamen.class));
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de eliminar una asignacionExamen por su identificador
	 * @param idAsignacionExamen
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminarAsignacionExamenById(@PathVariable Integer idAsignacionExamen) throws Exception {
		asignacionExamenService.eliminarAsignacionExamen(idAsignacionExamen);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
}
