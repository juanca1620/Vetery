package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "DTO utilizado para actualizar una mascota")
public class MascotaUpdateDto {

    @Schema(description = "ID de la mascota", example = "5", required = true)
    @NotNull(message = "El ID es obligatorio")
    @Positive(message = "El ID debe ser un número positivo")
    private Long id;

    @Schema(description = "Nombre de la mascota", example = "Luna", required = true)
    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @Schema(description = "Fecha de nacimiento de la mascota", example = "2020-06-15", required = true)
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @PastOrPresent(message = "La fecha de nacimiento debe ser en el pasado o presente")
    private LocalDate fechaNacimiento;
}