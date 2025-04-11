package com.vetery.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConsultorioCreateDto {

    @NotNull(message = "El número de consultorio no puede estar vacío")
    @Min(value = 1, message = "El número de consultorio debe ser mayor o igual a 1")
    @Max(value = 127, message = "El número de consultorio debe ser menor o igual a 127")
    private Byte noConsultorio;
    
    @NotNull(message = "El ID del veterinario no puede estar vacío")
    @Positive(message = "El ID del veterinario debe ser un número positivo")
    private Long veterinarioId;
    
}
