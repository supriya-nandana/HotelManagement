package com.example.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.Credentials;
import com.example.hotel.exceptions.InvalidCredentialsException;
import com.example.hotel.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * @param credentials
	 * @return user logged in
	 * @throws InvalidCredentialsException
	 */
	@PostMapping("/login")
	public String login(@RequestBody Credentials credentials) throws InvalidCredentialsException
	{
		boolean isExists=false;
		try {
			isExists = userService.authenticate(credentials.getUserName(),credentials.getPassword());
		} catch (InvalidCredentialsException e) {
			throw e;
		}
		if(isExists) return  "login success";
		return "please enter valid username and password";
	}
	
	
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> exceptionHandler(InvalidCredentialsException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
