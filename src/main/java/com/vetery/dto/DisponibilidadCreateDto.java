package com.vetery.dto;

import jakarta.validation.constraints.*;
import java.time.LocalTime;
import lombok.Data;

@Data
public class DisponibilidadCreateDto {

    @NotNull(message = "El día de la semana no puede estar vacío")
    @Min(value = 1, message = "El día de la semana debe ser entre 1 (Lunes) y 7 (Domingo)")
    @Max(value = 7, message = "El día de la semana debe ser entre 1 (Lunes) y 7 (Domingo)")
    private Byte diaSemana;
    
    @NotNull(message = "La hora de inicio no puede estar vacía")
    private LocalTime horaInicio;
    
    @NotNull(message = "La hora de fin no puede estar vacía")
    private LocalTime horaFin;
    
    @NotNull(message = "El ID del veterinario es obligatorio")
    @Positive(message = "El ID del veterinario debe ser un número positivo")
    private Long veterinarioId;

    @AssertTrue(message = "La hora de fin debe ser posterior a la hora de inicio")
    public boolean isHoraFinAfterHoraInicio() {
        return horaFin.isAfter(horaInicio);
    }
}