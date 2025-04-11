package com.vetery.exceptions;

public class VeterinarioIncorrectoException extends RuntimeException{

	public VeterinarioIncorrectoException () {
		super("Este veterinario no trabaja en esta veterinaria");
	}
}
