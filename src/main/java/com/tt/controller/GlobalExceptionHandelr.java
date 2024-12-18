package com.tt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Binding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandelr {

    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException excep){
		Map<String, String> errors = new HashMap<>();
		BindingResult bindingresult =  excep.getBindingResult();// Fixed variable name for consistency
		bindingresult.getFieldErrors().forEach((error)->{
			String fieldName = error.getField();//mail // Get the field name that failed validation
			String message = error.getDefaultMessage();// Get the default validation message
			
			errors.put(fieldName, message); // Add the error details to the map
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
