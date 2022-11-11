package com.te.resumebuilder.customexception;

public class NoRecordFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063625120800329218L;
	
	public NoRecordFoundException(String message) {
       super(message);
	}

}
