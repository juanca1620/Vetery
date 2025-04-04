package com.vetery.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "disponibilidad")
public class Disponibilidad {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dia_semana",nullable = false)
	private Byte diaSemana;
	
	@Column(name = "hora_inicio",nullable = false)
	private LocalTime horaInicio;
	
	@Column(name = "hora_fin",nullable = false)
	private LocalTime horaFin;
}
