/**
 * 
 */
package com.example.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.HotelRooms;

@Repository
public interface RoomDao extends CrudRepository<HotelRooms, Integer> {

	
	Optional<List<HotelRooms>> findAllByHotelId(int hotelId);

}
