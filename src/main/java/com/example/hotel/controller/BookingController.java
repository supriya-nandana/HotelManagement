package com.example.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.service.BookService;

@RestController
public class BookingController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/bookroom")
	public BookResponseDto bookRoom(@RequestBody BookRequestDto bookRequestDto) {
		return bookService.getBookingdetails(bookRequestDto);
	}
}
