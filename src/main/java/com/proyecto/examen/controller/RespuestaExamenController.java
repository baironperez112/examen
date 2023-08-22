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

import com.proyecto.examen.dto.RespuestaExamenDto;
import com.proyecto.examen.model.RespuestaExamen;
import com.proyecto.examen.service.RespuestaExamenService;



@RestController
@RequestMapping("/respuestaRespuestaExamen")
public class RespuestaExamenController {

	@Autowired
	private RespuestaExamenService respuestaExamenService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener todos los respuestaExamens
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/obtenerRespuestaExamens")
	public ResponseEntity<List<RespuestaExamenDto>> obtenerRespuestaExamenes() throws Exception{
		List<RespuestaExamenDto> respuestaExamens = respuestaExamenService.obtenerRespuestasExamen()
				.stream().map(p -> mapper.map(p, RespuestaExamenDto.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(respuestaExamens, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer el servicio para obtener un respuestaExamen por su ID
	 * @param idRespuestaExamen
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<RespuestaExamenDto> obtenerRespuestaExamenById(@PathVariable("id") Integer idRespuestaExamen) throws Exception {
		RespuestaExamenDto respuestaExamen = mapper.map(respuestaExamenService
				.obtenerRespuestaExamenById(idRespuestaExamen), RespuestaExamenDto.class);
		return new ResponseEntity<>(respuestaExamen, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de exponer un servicio para guardar un respuestaExamen
	 * @param respuestaExamen
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/guardarRespuestaExamen")
	public ResponseEntity<RespuestaExamenDto> guardarRespuestaExamen(@RequestBody RespuestaExamenDto respuestaExamen) throws Exception {
		RespuestaExamen response = respuestaExamenService.guardarRespuestaExamen(mapper.map(respuestaExamen, RespuestaExamen.class));
		RespuestaExamenDto respuestaExamenResponse = mapper.map(response, RespuestaExamenDto.class);
		
		RespuestaExamen Response = respuestaExamenService.obtenerRespuestaExamenById(respuestaExamenResponse.getId());
		return new ResponseEntity<>(respuestaExamenResponse, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo encargado de eliminar un respuestaExamen por su identificador
	 * @param idRespuestaExamen
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminarRespuestaExamenById(@PathVariable("id") Integer idRespuestaExamen) throws Exception {
		respuestaExamenService.eliminarRespuestaExamen(idRespuestaExamen);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
}
