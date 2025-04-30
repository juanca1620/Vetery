package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.Data;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Schema(description = "DTO para la creación de un administrador")
public class AdministradorCreateDto {

    @Schema(description = "Correo electrónico del administrador", example = "admin@veterinaria.com")
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    @Size(max = 100, message = "El correo electrónico no puede exceder los 100 caracteres")
    private String correo;

    @Schema(description = "Contraseña del administrador", example = "Segura123!")
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres")
    private String contrasenna;

    @Schema(description = "Nombre del administrador", example = "Ana")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Schema(description = "Apellido del administrador", example = "López")
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @Schema(description = "Fecha de nacimiento del administrador", example = "1985-07-20")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @Schema(description = "Cédula del administrador (7 a 10 dígitos)", example = "87654321")
    @NotNull(message = "La cédula no puede estar vacía")
    @Min(value = 1000000, message = "La cédula debe tener al menos 7 dígitos")
    @Max(value = 9999999999L, message = "La cédula no puede exceder los 10 dígitos")
    private Long cedula;
}