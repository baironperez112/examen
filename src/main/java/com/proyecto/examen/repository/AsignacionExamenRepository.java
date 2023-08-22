package com.proyecto.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.examen.model.AsignacionExamen;

@Repository
public interface AsignacionExamenRepository extends JpaRepository<AsignacionExamen, Integer> {

}
