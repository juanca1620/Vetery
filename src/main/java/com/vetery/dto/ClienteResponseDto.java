package com.vetery.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDate fechaNacimiento;
	
	private Long cedula;
	
	private Long veterinariaId;
}
