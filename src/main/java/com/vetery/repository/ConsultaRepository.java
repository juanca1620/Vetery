package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
