package com.te.studentqspiders.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.studentqspiders.customexception.DetailsNotFoundException;
import com.te.studentqspiders.customexception.SomethingWentWrongException;
import com.te.studentqspiders.response.Response;

@RestControllerAdvice
public class StudentQspidersExceptionHandler {
	
	@ExceptionHandler(DetailsNotFoundException.class)
	public ResponseEntity<Response> detailsNotFoundException(DetailsNotFoundException exception) {
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message("Details not found").build());
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<Response> somethingWentWrongException(SomethingWentWrongException exception) {
		return ResponseEntity.ok(Response.builder().error(Boolean.TRUE).message("Something Went Wrong").build());
	}
	

}
