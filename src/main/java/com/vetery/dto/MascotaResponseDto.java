package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.Data;

@Data
@Schema(description = "DTO de respuesta para la entidad Mascota")
public class MascotaResponseDto {

	@Schema(description = "ID único de la mascota", example = "10")
	private Long id;

	@Schema(description = "Nombre de la mascota", example = "Firulais")
	private String nombre;

	@Schema(description = "Fecha de nacimiento de la mascota", example = "2018-09-20")
	private LocalDate fechaNacimiento;

	@Schema(description = "ID del cliente dueño de la mascota", example = "3")
	private Long clienteId;
}
