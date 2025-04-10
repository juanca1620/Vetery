package com.vetery.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HorarioResponseDto {

	private Long id;
	
    private LocalDateTime fechaInicio;
    
    private LocalDateTime fechaFin;
}
