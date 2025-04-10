package com.vetery.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteCreateDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;
    
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;
    
    @NotNull(message = "La cédula no puede estar vacía")
    @Min(value = 1000000, message = "La cédula debe tener al menos 7 dígitos")
    @Max(value = 9999999999L, message = "La cédula no puede exceder los 10 dígitos")
    private Long cedula;
    
    @NotNull(message = "El ID de la veterinaria es obligatorio")
    @Positive(message = "El ID de la veterinaria debe ser un número positivo")
    private Long veterinariaId;
}
