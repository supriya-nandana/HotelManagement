package com.example.hotel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.RoomDao;
import com.example.hotel.dto.RoomsResponseDto;
import com.example.hotel.exceptions.RoomNotFoundException;
import com.example.hotel.model.HotelRooms;
import com.example.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	/*
	@Override
	public List<RoomsResponseDto> getRoomByHotelId(int hotelId) throws RoomNotFoundException {
		Optional<List<HotelRooms>> roomsOptional = roomDao.findAllByHotelId(hotelId);
		List<RoomsResponseDto> responseDto=new ArrayList<RoomsResponseDto>();
		if(roomsOptional.isPresent()) {
			BeanUtils.copyProperties(roomsOptional.get(), responseDto);
			return responseDto;
		}
		throw new RoomNotFoundException("There Exists No rooms with the given Id:"+hotelId);
	}*/
	
	@Override
	public List<RoomsResponseDto> getRoomByHotelId(int hotelId) throws RoomNotFoundException {
		Optional<List<HotelRooms>> ordersOptional=roomDao.findAllByHotelId(hotelId);
		if(ordersOptional.isPresent()) {
			List<HotelRooms> orders=ordersOptional.get();
			return orders.stream().map(order->getOrderResponse(order)).collect(Collectors.toList());
		}
		throw new RoomNotFoundException("No rooms found for the hotels..please visit again");
	}

	private RoomsResponseDto getOrderResponse(HotelRooms hotelrooms) {
		RoomsResponseDto responsedto=new RoomsResponseDto();
		BeanUtils.copyProperties(hotelrooms, responsedto);
		//responsedto.setProductName(roomDao.findProductNameByproductid(order.getProductid()));
		return responsedto;
	}

}
