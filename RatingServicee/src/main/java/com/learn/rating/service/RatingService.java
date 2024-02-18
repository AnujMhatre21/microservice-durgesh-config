package com.learn.rating.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.rating.entites.Rating;

@Service
public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getRating();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);           
}
