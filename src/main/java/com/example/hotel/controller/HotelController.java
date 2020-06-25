package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;
import com.example.hotel.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@GetMapping("/hotels/hotelLocation")
	public List<HotelsResponseDto> searchHotelsByLocation(@RequestParam("hotelLocation")String hotelLocation) throws HotelsNotFoundException {
		return hotelService.getHotelsByLocation(hotelLocation);
	}
	
	@ExceptionHandler(HotelsNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(HotelsNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
