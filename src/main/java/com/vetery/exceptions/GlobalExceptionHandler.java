package com.vetery.exceptions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex
    ) {
        Map<String, String> errorResponse = new HashMap<>();

        // Verifica si la causa es una propiedad no reconocida
        if (ex.getCause() instanceof UnrecognizedPropertyException) {
            UnrecognizedPropertyException unrecognizedException = (UnrecognizedPropertyException) ex.getCause();
            String fieldName = unrecognizedException.getPropertyName();
            errorResponse.put(
                "mensaje", 
                "El campo '" + fieldName + "' no es válido o no está permitido."
            );
        } else {
            errorResponse.put("mensaje", "Error en el formato del JSON enviado.");
        }

        return ResponseEntity.badRequest().body(errorResponse);
    }

	   @ExceptionHandler({
	        CannotGetJdbcConnectionException.class,  // Spring JDBC
	        org.springframework.jdbc.support.MetaDataAccessException.class,// JPA
	    })
	    public ResponseEntity<Map<String, String>> handleDatabaseConnectionErrors(Exception ex) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("mensaje", "Servicio no disponible temporalmente. Por favor, inténtelo más tarde.");
	        
	        return ResponseEntity
	            .status(HttpStatus.SERVICE_UNAVAILABLE) // 503
	            .body(errorResponse);
	    }

	    @ExceptionHandler({
	        org.springframework.orm.jpa.JpaSystemException.class, 
	        SQLException.class 
	    })
	    public ResponseEntity<Map<String, String>> handleDatabaseQueryErrors(Exception ex) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("mensaje", "Error interno al procesar la solicitud. Contacte al administrador.");
	        
	        
	        return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	            .body(errorResponse);
	    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> MethodArgumentNotValidExceptionHandler (MethodArgumentNotValidException ex){
		
		Map<String, String> resp =  new HashMap<>();
		ex.getBindingResult().getAllErrors().stream().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String cause = error.getDefaultMessage();
			resp.put(fieldName, cause);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecursoExistenteException.class)
	public ResponseEntity<Map<String,String>> RecursoExistenteException (RecursoExistenteException ex){
		Map<String,String> resp = Map.of("mensaje",ex.getMessage());
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AcesoNoAutorizadoException.class)
    public ResponseEntity<Map<String, String>> AcesoNoAutorizadoExceptionHandler(AcesoNoAutorizadoException ex) {
        Map<String, String> resp = Map.of(
            "mensaje", ex.getMessage()
        );
        return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> recursoNoEncontradoExceptionHandler (RecursoNoEncontradoException ex) {
        Map<String, String> resp = Map.of(
            "mensaje", ex.getMessage()
        );
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
	
	
	
}