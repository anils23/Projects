package com.te.ems.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.customexception.EmployeeNotFoundException;
import com.te.ems.customexception.SomethingWentWrongException;
import com.te.ems.response.Response;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Response> employeeNotFound(EmployeeNotFoundException e) {
		Response build = Response.builder().isError(true).message(e.getMessage()).build();
		return ResponseEntity.ok().body(build);
	}

	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<Response> somethingWentWrong(SomethingWentWrongException e) {
		Response build = Response.builder().isError(true).message(e.getMessage()).build();
		return ResponseEntity.ok().body(build);
	}

}
