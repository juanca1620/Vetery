package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "DTO de respuesta para la entidad Veterinaria")
public class VeterinariaResponseDto {

	@Schema(description = "Identificador único de la veterinaria", example = "1")
	private Long id;

	@Schema(description = "Ubicación de la veterinaria", example = "Calle Falsa 123, Buenos Aires")
	private String ubicacion;

	@Schema(description = "Datos del administrador asociado a la veterinaria")
	private AdministradorResponseDto administrador;
}
