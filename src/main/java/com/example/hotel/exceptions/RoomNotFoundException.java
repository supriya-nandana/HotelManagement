package com.example.hotel.exceptions;

public class RoomNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomNotFoundException(String message) {
		super(message);
	}
}
