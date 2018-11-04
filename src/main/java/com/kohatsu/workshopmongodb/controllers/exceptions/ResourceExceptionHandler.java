package com.kohatsu.workshopmongodb.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kohatsu.workshopmongodb.servicies.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado!", e.getMessage(), request.getRequestURI())
				);
	}
	
}
