package com.example.hotel.dto;

import java.time.LocalDateTime;

import com.example.hotel.model.Guests;

public class BookRequestDto {

	private int noOfGuests;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private int userId;
	private int roomId;
	private Guests guest;
	
	
	public Guests getGuest() {
		return guest;
	}
	public void setGuest(Guests guest) {
		this.guest = guest;
	}
	public int getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public LocalDateTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDateTime getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	
}
