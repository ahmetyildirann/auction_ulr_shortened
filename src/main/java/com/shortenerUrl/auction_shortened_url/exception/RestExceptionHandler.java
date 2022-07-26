package com.shortenerUrl.auction_shortened_url.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@RestControllerAdvice
public class RestExceptionHandler {


	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	  public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exceptions.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
	  }
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleExceptions(NotFoundException exception, WebRequest webRequest ){
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity=new ResponseEntity<>(response.getMessage(),HttpStatus.NOT_FOUND);
		return entity;
	}
	
}
