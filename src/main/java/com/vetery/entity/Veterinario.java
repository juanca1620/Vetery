package com.vetery.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "veterinario")
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100,nullable = false)
	private String nombre;
	
	@Column(length = 100,nullable = false)
	private String apellido;
	
	@Column(name = "fecha_nacimiento",nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(unique = true,nullable = false)
	private Long cedula;
}
