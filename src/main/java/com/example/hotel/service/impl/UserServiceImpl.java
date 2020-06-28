package com.example.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.UserDao;
import com.example.hotel.exceptions.InvalidCredentialsException;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	/**
	 * throws InvalidCredentialsException
	 *
	 */
	@Override
	public boolean authenticate(String userName, String password) throws InvalidCredentialsException {
		User user=userDao.findByUserNameAndPassword(userName, password);
		if(user!=null) return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials"); 
	}
	

}
