package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetery.entity.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

}
