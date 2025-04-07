package com.vetery.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VeterinariaCreateDto {

    @NotBlank(message = "La ubicación no puede estar vacía")
    @Size(min = 5, max = 200, message = "La ubicación debe tener entre 5 y 200 caracteres")
    private String ubicacion;
    
    @NotNull(message = "La información del administrador es obligatoria")
    @Valid
    private AdministradorCreateDto administrador;
}
