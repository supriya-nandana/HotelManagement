package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.RoomsResponseDto;
import com.example.hotel.exceptions.RoomNotFoundException;
import com.example.hotel.service.RoomService;


@RestController
public class RoomDetailsController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/rooms/{hotelId}")
	public List<RoomsResponseDto> getRoomByHotelId(@PathVariable int hotelId) throws RoomNotFoundException
	{
		return roomService.getRoomByHotelId(hotelId);
	}
	
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(RoomNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
