package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "DTO que representa un consultorio registrado en una veterinaria")
public class ConsultorioResponseDto {

	@Schema(description = "ID único del consultorio", example = "1")
	private Long id;

	@Schema(description = "Número identificador del consultorio dentro de la veterinaria", example = "3")
	private Byte noConsultorio;

	@Schema(description = "ID de la veterinaria a la que pertenece el consultorio", example = "10")
	private Long veterinariaId;
}
