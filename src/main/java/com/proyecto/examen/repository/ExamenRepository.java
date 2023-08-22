package com.proyecto.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.examen.model.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {

}
