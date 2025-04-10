package com.vetery.dto;

import lombok.Data;

@Data
public class FacturaResponseDto {
	
	private Long id;
	
	private Double precio;
	
	private Long consultaId;
	
	private Long clienteId;
	
	private Long veterinariaId;
}
