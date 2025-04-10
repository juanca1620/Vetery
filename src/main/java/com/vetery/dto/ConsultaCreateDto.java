package com.vetery.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConsultaCreateDto {

    @NotBlank(message = "El nombre de la consulta no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El ID de la mascota es obligatorio")
    @Positive(message = "El ID de la mascota debe ser un número positivo")
    private Long mascotaId;
}