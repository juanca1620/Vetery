package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "DTO para la creación de un veterinario")
public class VeterinarioCreateDto {

    @Schema(description = "Nombre del veterinario", example = "Carlos")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Schema(description = "Apellido del veterinario", example = "Ramírez")
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @Schema(description = "Fecha de nacimiento del veterinario", example = "1990-03-15")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @Schema(description = "Cédula del veterinario (7 a 10 dígitos)", example = "12345678")
    @NotNull(message = "La cédula no puede estar vacía")
    @Positive(message = "La cédula debe ser un número positivo")
    @Min(value = 1000000, message = "La cédula debe tener al menos 7 dígitos")
    @Max(value = 9999999999L, message = "La cédula no puede exceder los 10 dígitos")
    private Long cedula;

    @Schema(description = "ID de la veterinaria asociada", example = "2")
    @NotNull(message = "El ID de veterinario es obligatorio")
    @Positive(message = "El ID de veterinario debe ser positivo")
    private Long veterinariaId;
}