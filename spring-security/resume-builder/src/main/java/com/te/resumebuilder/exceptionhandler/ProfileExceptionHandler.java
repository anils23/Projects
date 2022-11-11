package com.te.resumebuilder.exceptionhandler;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.customexception.NoRecordFoundException;
import com.te.resumebuilder.customexception.SomethingWentWrongException;
import com.te.resumebuilder.response.Response;


@RestControllerAdvice
public class ProfileExceptionHandler {

	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<Response> somethingWentWrong(SomethingWentWrongException exception) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.TRUE).message(exception.getMessage()).build());
	}

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<Response> noRecordFoundException(NoRecordFoundException exception) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.TRUE).message(exception.getMessage()).build());
	}

}
