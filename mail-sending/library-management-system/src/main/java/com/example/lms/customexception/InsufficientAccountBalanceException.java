package com.example.lms.customexception;

public class InsufficientAccountBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432629060286156555L;

	public InsufficientAccountBalanceException(String message) {
     super(message);
	}
}
