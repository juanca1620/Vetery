package com.vetery.dto;

import java.time.LocalDate;

import com.vetery.entity.Veterinaria;

import lombok.Data;

@Data
public class VeterinarioResponseDto {

	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDate fechaNacimiento;
	
	private Long cedula;
	
	private Long veterinariaId;
}
