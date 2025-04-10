package com.vetery.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "administrador")
@Data
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (length = 100,nullable = false)
	private String correo;
	
	@Column(length = 255,nullable = false)
	private String contrasenna;
	
	@Column(length = 100,nullable = false)
	private String nombre;
	
	@Column(length = 100,nullable = false)
	private String apellido;
	
	@Column(name = "fecha_nacimiento",nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(unique = true,nullable = false)
	private Long cedula;
	
	@OneToOne(mappedBy = "administrador",fetch = FetchType.LAZY)
	private Veterinaria veterinaria;
}
