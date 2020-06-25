package com.example.hotel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	/**
	 * @param userName
	 * @param password
	 * @return  user logged in
	 */
	User findByUserNameAndPassword(String userName, String password);

	
	

}
