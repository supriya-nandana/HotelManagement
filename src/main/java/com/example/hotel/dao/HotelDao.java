package com.example.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.Hotels;

@Repository
public interface HotelDao extends CrudRepository<Hotels, Integer> {

	@Query(value = "select * from hotels h where h.hotel_location like %:hotelLocation%",nativeQuery = true)
	Optional<List<Hotels>> getHotelsByLocation(String hotelLocation);

	@Query(value="select h.hotel_name from hotels h where h.hotel_id=:hotelId",nativeQuery = true)
	String findHotelNameByHotelId(@Param("hotelId")int hotelId);

	
}
