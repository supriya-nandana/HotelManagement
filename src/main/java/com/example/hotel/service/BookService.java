package com.example.hotel.service;

import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;

public interface BookService {

	BookResponseDto getBookingdetails(BookRequestDto bookRequestDto);

}
