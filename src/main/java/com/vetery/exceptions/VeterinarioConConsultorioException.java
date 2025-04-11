package com.vetery.exceptions;

public class VeterinarioConConsultorioException extends RuntimeException{

	public VeterinarioConConsultorioException() {
		super("Error:este veterinario ya esta trabajando en un consultorio");
	}

	
}
