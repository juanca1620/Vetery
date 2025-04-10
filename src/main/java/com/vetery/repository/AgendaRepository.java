package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetery.entity.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
