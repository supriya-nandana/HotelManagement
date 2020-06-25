package com.example.hotel.service;

import java.util.List;

import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;

public interface HotelService {

	List<HotelsResponseDto> getHotelsByLocation(String hotelLocation) throws HotelsNotFoundException;

}
