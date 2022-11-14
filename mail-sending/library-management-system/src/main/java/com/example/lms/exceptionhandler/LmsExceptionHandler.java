package com.example.lms.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.lms.customexception.BookNotAvailableException;
import com.example.lms.customexception.BookNotFoundException;
import com.example.lms.customexception.InsufficientAccountBalanceException;
import com.example.lms.customexception.UserNotFoundException;
import com.example.lms.response.Response;

@RestControllerAdvice
public class LmsExceptionHandler {
	
	@ExceptionHandler(BookNotAvailableException.class)
	public ResponseEntity<Response> bookNotAvailable(BookNotAvailableException e){
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message(e.getMessage()).build());
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Response> bookNotFound(BookNotFoundException e){
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message(e.getMessage()).build());
	}
	
	@ExceptionHandler(InsufficientAccountBalanceException.class)
	public ResponseEntity<Response> insufficientAccountBalance(InsufficientAccountBalanceException e){
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message(e.getMessage()).build());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response> userNotFound(UserNotFoundException e){
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message(e.getMessage()).build());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> somethingWentWrong(RuntimeException e){
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message("Something Went Wrong").build());
	}

}
