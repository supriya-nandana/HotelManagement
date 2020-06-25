package com.example.hotel.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.BookDao;
import com.example.hotel.dao.HotelDao;
import com.example.hotel.dao.RoomDao;
import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.dto.Dto;
import com.example.hotel.helper.RoomHelper;
import com.example.hotel.model.Booking;
import com.example.hotel.service.BookService;

@Service
public class BookingServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	@Autowired
	RoomDao roomDao;
	@Autowired
	HotelDao hotelDao;
	
	@Override
	public BookResponseDto getBookingdetails(BookRequestDto bookRequestDto) {
		Booking book=new Booking();
		BeanUtils.copyProperties(bookRequestDto, book);
		book.getGuests().add(bookRequestDto.getGuest());
		book.setBookingTime(LocalDateTime.now());
		book.setRoomNumber(RoomHelper.getRoomNumber());		
		double diff=((bookRequestDto.getCheckOut().getDayOfMonth())-(bookRequestDto.getCheckIn().getDayOfMonth()));
		book.setTotalPrice(roomDao.findPriceByRoomId(bookRequestDto.getRoomId())*diff);
		Booking bookings=bookDao.save(book);
		
		BookResponseDto bookresponsedto=new BookResponseDto();
		 BeanUtils.copyProperties(bookings, bookresponsedto);		
		 bookresponsedto.setRoomType(roomDao.findRoomTypeByRoomId(bookRequestDto.getRoomId()));
		Dto dto=new Dto(); 
		 dto.setHotelId(roomDao.findHotelIdByRoomId(bookRequestDto.getRoomId()));
		 bookresponsedto.setHotelName(hotelDao.findHotelNameByHotelId(dto.getHotelId()));
		 
		return bookresponsedto;
	 
		
		
		/*
		if(bookings.getBookingId()<=0)return "could not place booking please try agin after sometime";
		return "booking has placed successfully, your bookId:"+bookings.getBookingId();
		}*/
		 
	}
}

	

