package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "DTO para la creación de una nueva consulta médica")
public class ConsultaCreateDto {

    @Schema(description = "Nombre o título de la consulta", example = "Consulta general de salud")
    @NotBlank(message = "El nombre de la consulta no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @Schema(description = "ID de la mascota asociada a la consulta", example = "12")
    @NotNull(message = "El ID de la mascota es obligatorio")
    @Positive(message = "El ID de la mascota debe ser un número positivo")
    private Long mascotaId;
}