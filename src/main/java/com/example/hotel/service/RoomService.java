package com.example.hotel.service;

import java.util.List;

import com.example.hotel.dto.RoomsResponseDto;
import com.example.hotel.exceptions.RoomNotFoundException;

public interface RoomService {

	 public List<RoomsResponseDto> getRoomByHotelId(int hotelId) throws RoomNotFoundException;

}
