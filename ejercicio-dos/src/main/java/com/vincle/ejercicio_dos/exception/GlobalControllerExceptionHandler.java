package com.vincle.ejercicio_dos.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
    @Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL() ,details);		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());    	
	}

	@ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handle(ResourceNotFoundException ex) {
		ErrorMessage errorMessage = null;
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		if (ex.getCode() != null) {
			errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getCode(), "Resource Not Found", details);
		} else {
			errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), "Resource Not Found", details);
		}		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }	
	

	@ExceptionHandler({ClientException.class})
    public ResponseEntity<Object> handle(ClientException ex) {
		ErrorMessage errorMessage = null;
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());		
		if (ex.getCode() != null) {
			errorMessage = new ErrorMessage(HttpStatus.CONFLICT, ex.getCode(), "Conflict", details);
		} else {
			errorMessage = new ErrorMessage(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), "Conflict", details);
		}
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
	
	@ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handle(BadRequestException ex) {
		ErrorMessage errorMessage = null;
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		if (ex.getCode() != null) {
			errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getCode(), "Argument Not Valid", details);
		} else {
			errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Argument Not Valid", details);
		}		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
	
	@ExceptionHandler({InternalServerException.class})
    public ResponseEntity<Object> handle(InternalServerException ex) {
		ErrorMessage errorMessage = null;
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		if (ex.getCode() != null) {
			errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCode(), "INTERNAL SERVER ERROR", details);
		} else {
			errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL SERVER ERROR", details);
		}	
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		ex.getBindingResult()
	    .getFieldErrors()
	    .stream()
	    .forEach(x -> details.add(x.getDefaultMessage()));
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Argument Not Valid", details);		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus()); 
	}
	

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL SERVER ERROR", details);	
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}	
    
}
