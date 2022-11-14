package com.example.lms.customexception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5871583814097399521L;
	
	public UserNotFoundException(String message) {
      super(message);
	}

}
