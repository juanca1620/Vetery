package com.vetery.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AdministradorResponseDto {
	
	private Long id;
	
    private String correo;
    
    private String nombre;
    
    private String apellido;
    
    private LocalDate fechaNacimiento;
    
    private Long cedula;
}
