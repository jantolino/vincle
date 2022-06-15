package com.vincle.ejercicio_dos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception NotValidException 
 *
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer code;
	
	public BadRequestException(String message) {
		this.message = message;
	}
	
	public BadRequestException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
