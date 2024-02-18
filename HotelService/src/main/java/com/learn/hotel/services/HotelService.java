package com.learn.hotel.services;

import java.util.List;

import com.learn.hotel.entites.Hotel;

public interface HotelService {

//	create
	Hotel create(Hotel hotel);

//	getall
	List<Hotel> getAll();

//	GEt single
	Hotel getHotel(String id);

}
