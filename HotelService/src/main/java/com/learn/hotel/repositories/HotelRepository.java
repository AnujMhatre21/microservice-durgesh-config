package com.learn.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.hotel.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
	
}
