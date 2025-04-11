package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.Data;

@Data
@Schema(description = "DTO para mostrar la información de un cliente")
public class ClienteResponseDto {

	@Schema(description = "ID único del cliente", example = "1")
	private Long id;

	@Schema(description = "Nombre del cliente", example = "Juan")
	private String nombre;

	@Schema(description = "Apellido del cliente", example = "Pérez")
	private String apellido;

	@Schema(description = "Fecha de nacimiento del cliente", example = "1985-10-25")
	private LocalDate fechaNacimiento;

	@Schema(description = "Cédula del cliente", example = "12345678")
	private Long cedula;

	@Schema(description = "ID de la veterinaria asociada", example = "3")
	private Long veterinariaId;
}
