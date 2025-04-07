package com.vetery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetery.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
