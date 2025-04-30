package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.Data;

@Data
@Schema(description = "DTO de respuesta para la entidad Administrador")
public class AdministradorResponseDto {

    @Schema(description = "Identificador único del administrador", example = "1")
    private Long id;

    @Schema(description = "Correo electrónico del administrador", example = "admin@veterinaria.com")
    private String correo;

    @Schema(description = "Nombre del administrador", example = "Carlos")
    private String nombre;

    @Schema(description = "Apellido del administrador", example = "Ramírez")
    private String apellido;

    @Schema(description = "Fecha de nacimiento del administrador", example = "1980-04-20")
    private LocalDate fechaNacimiento;

    @Schema(description = "Cédula del administrador", example = "1234567890")
    private Long cedula;
}
