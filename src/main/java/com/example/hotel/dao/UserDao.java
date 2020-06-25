package com.example.hotel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUserNameAndPassword(String userName, String password);

	
	

}
