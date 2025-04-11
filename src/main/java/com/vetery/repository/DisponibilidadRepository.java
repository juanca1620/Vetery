package com.vetery.repository;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Disponibilidad;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long>{

	@Query(value = "SELECT * FROM disponibilidad WHERE veterinario_id = ?1 AND dia_semana = ?2 AND NOT (hora_inicio > ?3 OR hora_fin < ?4) LIMIT 1", nativeQuery = true)
	Optional<Disponibilidad> findCrossedDisponibilidad(Long vetId, Byte diaSemana, LocalTime horaInicio, LocalTime horaFin);

}
