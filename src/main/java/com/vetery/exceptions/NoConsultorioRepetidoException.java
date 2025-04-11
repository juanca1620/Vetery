package com.vetery.exceptions;

public class NoConsultorioRepetidoException extends RuntimeException{
	public NoConsultorioRepetidoException () {
		super("Este numero de consultorio ya esta en uso por esta veterinaria");
	}
}
