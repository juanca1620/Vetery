package com.vetery.exceptions;

public class RecursoExistenteException extends RuntimeException {
    public RecursoExistenteException(String mensaje) {
        super(mensaje); 
    }
}
