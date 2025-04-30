package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "DTO utilizado para registrar un nuevo cliente en una veterinaria")
public class ClienteCreateDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-05-15")
    private LocalDate fechaNacimiento;

    @NotNull(message = "La cédula no puede estar vacía")
    @Min(value = 1000000, message = "La cédula debe tener al menos 7 dígitos")
    @Max(value = 9999999999L, message = "La cédula no puede exceder los 10 dígitos")
    @Schema(description = "Número de cédula del cliente", example = "1234567890")
    private Long cedula;

    @NotNull(message = "El ID de la veterinaria es obligatorio")
    @Positive(message = "El ID de la veterinaria debe ser un número positivo")
    @Schema(description = "ID de la veterinaria asociada al cliente", example = "5")
    private Long veterinariaId;
}
