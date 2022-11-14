package com.example.lms.customexception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6637461596776791445L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
