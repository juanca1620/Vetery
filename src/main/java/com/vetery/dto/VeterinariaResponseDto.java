package com.vetery.dto;

import lombok.Data;

@Data
public class VeterinariaResponseDto {

	private Long id;
	
	private String ubicacion;
	
	private AdministradorResponseDto administrador;
}
