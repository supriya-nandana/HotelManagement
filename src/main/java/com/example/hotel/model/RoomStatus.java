package com.example.hotel.model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class RoomStatus {

	private String Status;
	private LocalDate date;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
