package com.vetery.exceptions;

public class AcesoNoAutorizadoException extends RuntimeException{

	public AcesoNoAutorizadoException() {
		super("Aceso denegado, credenciales incorrectas");
	}

	
}
