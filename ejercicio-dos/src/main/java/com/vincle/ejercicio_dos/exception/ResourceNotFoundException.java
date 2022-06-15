package com.vincle.ejercicio_dos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception ResourceNotFoundException 
 *
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer code;
	
	public ResourceNotFoundException(String message) {
		this.message = message;
	}
	
	public ResourceNotFoundException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
