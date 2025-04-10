package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Veterinaria;

@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria, Long>{

}
