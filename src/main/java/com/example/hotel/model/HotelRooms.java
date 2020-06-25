package com.example.hotel.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	 private int roomId;
	private int hotelId;
	private String roomType;
	private double price;
	private int noOfBeds;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "roomId", column = @Column(name = "hotel_room_id")),
		  @AttributeOverride( name = "status", column = @Column(name = "status")),
		  @AttributeOverride( name = "date", column = @Column(name = "date"))
		})
	private RoomStatus roomStatus;
	
	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	
	
	
}
