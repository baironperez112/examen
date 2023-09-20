package com.proyecto.examen.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.proyecto.examen.dto.ExamenDto;
import com.proyecto.examen.model.Examen;
import com.proyecto.examen.service.ExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private ExamenService examenService;
	
	@Autowired
	private ModelMapper mapper;
	
	//asasasas
	/**
	 * Metodo encargado de exponer el servicio para obtener todos los examens
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/obtenerExamens")
	public List<ExamenDto> obtenerExamenes() throws Exception{
		List<Examen> examenes = examenService.obtenerExamenes();
		List<ExamenDto> examenesResponse = new ArrayList<>();
		examenes.forEach(item -> {
			examenesResponse.add(ExamenDto.CONVERT_DTO.apply(item));
		});
		return examenesResponse;
	}
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener un examen por su ID
	 * @param idExamen
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ExamenDto> obtenerExamenById(@PathVariable("id") Integer idExamen) throws Exception {
		Examen examen = examenService.obtenerExamenById(idExamen);
		ExamenDto examenDto = ExamenDto.CONVERT_DTO.apply(examen);
		return new ResponseEntity<>(examenDto, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer un servicio para guardar un examen
	 * @param examen
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/guardarExamen")
	public ResponseEntity<Boolean> guardarExamen(@RequestBody ExamenDto examen) throws Exception {
		examenService.guardarExamen(mapper.map(examen, Examen.class));
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de eliminar un examen por su identificador
	 * @param idExamen
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminarExamenById(@PathVariable Integer idExamen) throws Exception {
		examenService.eliminarExamen(idExamen);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
}
