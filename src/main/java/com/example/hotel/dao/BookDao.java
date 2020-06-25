package com.example.hotel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.hotel.model.Booking;

@Repository
public interface BookDao extends CrudRepository<Booking, Integer> {

}
