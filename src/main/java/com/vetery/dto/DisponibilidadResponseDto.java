package com.vetery.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class DisponibilidadResponseDto {

	private Long id;
	
    private Byte diaSemana;
    
    private LocalTime horaInicio;
    
    private LocalTime horaFin;
    
    private Long veterinarioId;
}
