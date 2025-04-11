package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Schema(description = "DTO para la creación de una mascota")
public class MascotaCreateDto {

    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Schema(description = "Nombre de la mascota", example = "Firulais")
    private String nombre;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @PastOrPresent(message = "La fecha de nacimiento debe ser en el pasado o presente")
    @Schema(description = "Fecha de nacimiento de la mascota", example = "2020-05-10")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El ID del cliente es obligatorio")
    @Positive(message = "El ID del cliente debe ser un número positivo")
    @Schema(description = "ID del cliente al que pertenece la mascota", example = "1")
    private Long clienteId;
}