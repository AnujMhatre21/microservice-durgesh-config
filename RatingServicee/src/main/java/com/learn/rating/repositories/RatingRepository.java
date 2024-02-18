package com.learn.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.rating.entites.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
//	********* CamelCase is Mandatory ********
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	

}
