package com.example.lms.customexception;

public class BookNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5258821584413581298L;
	
	public BookNotAvailableException(String message) {
       super(message);
	}

}
