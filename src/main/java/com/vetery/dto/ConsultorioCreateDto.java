package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "DTO utilizado para registrar un nuevo consultorio")
public class ConsultorioCreateDto {

    @NotNull(message = "El número de consultorio no puede estar vacío")
    @Min(value = 1, message = "El número de consultorio debe ser mayor o igual a 1")
    @Max(value = 127, message = "El número de consultorio debe ser menor o igual a 127")
    @Schema(description = "Número identificador del consultorio", example = "3", minimum = "1", maximum = "127", required = true)
    private Byte noConsultorio;

    @NotNull(message = "El ID del veterinario no puede estar vacío")
    @Positive(message = "El ID del veterinario debe ser un número positivo")
    @Schema(description = "ID del veterinario asignado al consultorio", example = "12", required = true)
    private Long veterinarioId;

}
