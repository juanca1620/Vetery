package com.vetery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetery.dto.CedulaPersona;

@Repository
public interface CedulaRepository extends JpaRepository<CedulaPersona, Long> {
    
    @Query(value = "SELECT cedula FROM cedulas_personas", nativeQuery = true)
    List<Long> findAllCedulas();
    
}
