package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long>{

}
