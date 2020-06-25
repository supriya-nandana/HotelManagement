package com.example.hotel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.HotelDao;
import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;
import com.example.hotel.model.Hotels;
import com.example.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;
	
	@Override
	public List<HotelsResponseDto> getHotelsByLocation(String hotelLocation) throws HotelsNotFoundException {
		Optional<List<Hotels>> hotelsOptional=hotelDao.getHotelsByLocation(hotelLocation);
		if(hotelsOptional.isPresent()) {
		return hotelsOptional.get().stream().map(hotel->getHotelDto(hotel)).collect(Collectors.toList());
	}
		throw new HotelsNotFoundException("There exists no hotels with the given location:"+hotelLocation);

	}

	private HotelsResponseDto getHotelDto(Hotels hotel) {
		HotelsResponseDto responseDto= new HotelsResponseDto();
		BeanUtils.copyProperties(hotel, responseDto);
		return responseDto;
	}
	
}
