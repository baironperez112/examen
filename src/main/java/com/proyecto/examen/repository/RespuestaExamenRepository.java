package com.proyecto.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.examen.model.RespuestaExamen;

@Repository
public interface RespuestaExamenRepository extends JpaRepository<RespuestaExamen, Integer> {

}
