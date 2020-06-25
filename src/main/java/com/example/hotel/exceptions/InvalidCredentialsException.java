package com.example.hotel.exceptions;

public class InvalidCredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public InvalidCredentialsException(String message) {
		super();
		this.message = message;
	}
	public InvalidCredentialsException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
