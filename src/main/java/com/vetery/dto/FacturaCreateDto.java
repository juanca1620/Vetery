package com.vetery.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FacturaCreateDto {

    @NotNull(message = "El precio no puede estar vacío")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    @DecimalMax(value = "99999999.99", message = "El precio no puede exceder 99,999,999.99")
    private Double precio;
    
    @NotNull(message = "El ID de consulta es obligatorio")
    @Positive(message = "El ID de consulta debe ser un número positivo")
    private Long consultaId;
    
    @NotNull(message = "El ID de cliente es obligatorio")
    @Positive(message = "El ID de cliente debe ser un número positivo")
    private Long clienteId;
    
    @NotNull(message = "El ID de veterinaria es obligatorio")
    @Positive(message = "El ID de veterinaria debe ser un número positivo")
    private Long veterinariaId;
}