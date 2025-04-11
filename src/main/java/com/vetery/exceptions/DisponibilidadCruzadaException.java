package com.vetery.exceptions;

public class DisponibilidadCruzadaException extends RuntimeException{

	public DisponibilidadCruzadaException() {
		super("Este horario se cruza con otro horario de este veterinario, por favor verificar las disponibilidades de este");
		// TODO Auto-generated constructor stub
	}

	
}
