package com.vetery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Consultorio;
import com.vetery.entity.Veterinaria;
import com.vetery.entity.Veterinario;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long>{

	Optional<Consultorio> findByVeterinario (Veterinario veterinario);
	
	Optional<Consultorio> findByVeterinariaAndNoConsultorio (Veterinaria veterinaria,Byte noConsultorio);
}
