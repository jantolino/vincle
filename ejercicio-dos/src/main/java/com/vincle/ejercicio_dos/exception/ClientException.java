package com.vincle.ejercicio_dos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Business Exception ClientException
 *
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.CONFLICT)
public class ClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer code;

	public ClientException(String message) {		
		this.message = message;
	}

	public ClientException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
