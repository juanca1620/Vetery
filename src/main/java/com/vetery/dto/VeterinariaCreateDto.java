package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "DTO para la creación de una veterinaria junto con su administrador")
public class VeterinariaCreateDto {

    @Schema(description = "Ubicación de la veterinaria", example = "Avenida Principal 123, Ciudad X")
    @NotBlank(message = "La ubicación no puede estar vacía")
    @Size(min = 5, max = 200, message = "La ubicación debe tener entre 5 y 200 caracteres")
    private String ubicacion;

    @Schema(description = "Información del administrador asociado a la veterinaria")
    @NotNull(message = "La información del administrador es obligatoria")
    @Valid
    private AdministradorCreateDto administrador;
}
