package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "DTO para actualizar los datos de un veterinario")
public class VeterinarioUpdateDto {

    @NotNull(message = "El ID no puede ser nulo")
    @Schema(description = "ID del veterinario a actualizar", example = "5", required = true)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Schema(description = "Nombre del veterinario", example = "Carlos", required = true)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Schema(description = "Apellido del veterinario", example = "Ramírez", required = true)
    private String apellido;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Schema(description = "Fecha de nacimiento del veterinario (formato yyyy-MM-dd)", example = "1990-05-12", required = true)
    private LocalDate fechaNacimiento;
}