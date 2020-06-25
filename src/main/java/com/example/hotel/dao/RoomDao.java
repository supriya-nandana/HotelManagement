/**
 * 
 */
package com.example.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.HotelRooms;

@Repository
public interface RoomDao extends CrudRepository<HotelRooms, Integer> {

	
	Optional<List<HotelRooms>> findAllByHotelId(int hotelId);

	@Query(value = "select r.price from hotel_rooms r where r.room_id=:roomId",nativeQuery = true)
    double findPriceByRoomId(@Param("roomId") int roomId);
    
	@Query(value="select r.room_type from hotel_rooms r where r.room_id=:roomId",nativeQuery = true)
	String findRoomTypeByRoomId(@Param("roomId")int roomId);
	
	@Query(value="select r.hotel_id from hotel_rooms r where r.room_id=:roomId",nativeQuery = true)
	int findHotelIdByRoomId(@Param("roomId")int roomId);

	
}
