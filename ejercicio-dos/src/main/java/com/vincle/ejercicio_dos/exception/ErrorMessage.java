package com.vincle.ejercicio_dos.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
	
	private Integer code;
    private HttpStatus status;
    private String message;
    private List<String> errors;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(HttpStatus status, Integer code, String message, List<String> errors) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.errors = errors;
	}
	
    public ErrorMessage(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorMessage(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }    
    
}
