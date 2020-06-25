package com.example.hotel.helper;

public class RoomHelper {

	private static int roomNumber=1000;

	public static int getRoomNumber() {
		return roomNumber++;
	}

}
