package com.cg.zmart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(NotFoundException ex, WebRequest request) {
		ex.setMessage("This product is not available.");
		NotFoundException nfe = new NotFoundException(ex.getMessage());
		return new ResponseEntity<>(nfe, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		NotFoundException nfe = new NotFoundException(ex.getMessage());
		return new ResponseEntity<>(nfe, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
