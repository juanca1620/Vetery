package com.vetery.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

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
	
}
