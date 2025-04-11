package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.*;
import java.time.LocalTime;
import lombok.Data;

@Data
@Schema(description = "DTO para la creación de la disponibilidad de un veterinario")
public class DisponibilidadCreateDto {

    @NotNull(message = "El día de la semana no puede estar vacío")
    @Min(value = 1, message = "El día de la semana debe ser entre 1 (Lunes) y 7 (Domingo)")
    @Max(value = 7, message = "El día de la semana debe ser entre 1 (Lunes) y 7 (Domingo)")
    @Schema(description = "Día de la semana (1=Lunes, 7=Domingo)", example = "3")
    private Byte diaSemana;

    @NotNull(message = "La hora de inicio no puede estar vacía")
    @Schema(description = "Hora de inicio de la disponibilidad (formato HH:mm)", example = "09:00")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin no puede estar vacía")
    @Schema(description = "Hora de fin de la disponibilidad (formato HH:mm)", example = "13:00")
    private LocalTime horaFin;

    @NotNull(message = "El ID del veterinario es obligatorio")
    @Positive(message = "El ID del veterinario debe ser un número positivo")
    @Schema(description = "ID del veterinario que tendrá la disponibilidad", example = "5")
    private Long veterinarioId;

    @AssertTrue(message = "La hora de fin debe ser posterior a la hora de inicio")
    @Schema(description = "Validación que asegura que la hora de fin es posterior a la de inicio", hidden = true)
    public boolean isHoraFinAfterHoraInicio() {
        return horaFin != null && horaInicio != null && horaFin.isAfter(horaInicio);
    }
}