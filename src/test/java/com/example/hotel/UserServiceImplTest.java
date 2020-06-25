package com.example.hotel;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hotel.dao.UserDao;
import com.example.hotel.dto.Credentials;
import com.example.hotel.exceptions.InvalidCredentialsException;
import com.example.hotel.model.User;
import com.example.hotel.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	    User user;
		
		@Mock
		UserDao userDao;
		
		@InjectMocks
		UserServiceImpl userServiceImpl;
		
		Credentials credentials;
		
		
		@Test
		public void authenticateTest1() throws InvalidCredentialsException {
			//given
			User user=new User();
			user.setUserName("manasa");
			user.setPassword("1234");			
			//when
			when(userDao.findByUserNameAndPassword("manasa","1234")).thenReturn(user);				
			//then
			Boolean isExists = userServiceImpl.authenticate("manasa", "1234");
			verify(userDao).findByUserNameAndPassword("manasa","1234");
			assertTrue(isExists);
		}
		
		@Test
		public void authenticateTest2() {
			//given
			User user = new User();
			user.setUserName("manasa");
			user.setPassword("1234");	
			//when
			when(userDao.findByUserNameAndPassword("manasa","1234")).thenReturn(null);
			//then
			assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticate("manasa", "1234"));
		}
		
		

}
