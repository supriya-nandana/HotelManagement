package com.example.hotel.service;

import com.example.hotel.exceptions.InvalidCredentialsException;

public interface UserService {

	boolean authenticate(String userName, String password) throws InvalidCredentialsException;
	

}
