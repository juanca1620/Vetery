package com.vetery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalTime;

import lombok.Data;

@Data
@Schema(description = "DTO que representa la respuesta con los datos de una disponibilidad registrada")
public class DisponibilidadResponseDto {

    @Schema(description = "ID único de la disponibilidad", example = "10")
    private Long id;

    @Schema(description = "Día de la semana (1=Lunes, 7=Domingo)", example = "2")
    private Byte diaSemana;

    @Schema(description = "Hora de inicio de la disponibilidad", example = "08:30")
    private LocalTime horaInicio;

    @Schema(description = "Hora de fin de la disponibilidad", example = "12:30")
    private LocalTime horaFin;

    @Schema(description = "ID del veterinario al que pertenece la disponibilidad", example = "5")
    private Long veterinarioId;
}
