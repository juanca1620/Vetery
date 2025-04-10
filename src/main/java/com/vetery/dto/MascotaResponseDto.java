package com.vetery.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MascotaResponseDto {

	private Long id;
	
	private String nombre;
	
	private LocalDate fechaNacimiento;
	
	private Long clienteId;
}
