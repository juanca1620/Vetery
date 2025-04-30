package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import com.vetery.entity.Veterinaria;

import lombok.Data;

@Data
@Schema(description = "DTO de respuesta con los datos del veterinario")
public class VeterinarioResponseDto {

	@Schema(description = "ID único del veterinario", example = "1")
	private Long id;

	@Schema(description = "Nombre del veterinario", example = "Laura")
	private String nombre;

	@Schema(description = "Apellido del veterinario", example = "Gómez")
	private String apellido;

	@Schema(description = "Fecha de nacimiento del veterinario (formato yyyy-MM-dd)", example = "1988-04-23")
	private LocalDate fechaNacimiento;

	@Schema(description = "Número de cédula profesional del veterinario", example = "123456789")
	private Long cedula;

	@Schema(description = "ID de la veterinaria a la que pertenece el veterinario", example = "10")
	private Long veterinariaId;
}
