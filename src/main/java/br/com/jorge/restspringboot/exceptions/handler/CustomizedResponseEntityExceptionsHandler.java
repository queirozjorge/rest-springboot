package br.com.jorge.restspringboot.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jorge.restspringboot.exceptions.ResponseException;
import br.com.jorge.restspringboot.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionsHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseException> handleAllExceptions(Exception ex, WebRequest request) {
		ResponseException responseException  = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ResponseException> handleNotFoundExceptions(Exception ex, WebRequest request) {
		ResponseException responseException  = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
	}
	
}
