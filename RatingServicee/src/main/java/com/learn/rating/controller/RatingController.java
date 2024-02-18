package com.learn.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.rating.entites.Rating;
import com.learn.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getRating() {
		return ResponseEntity.ok(ratingService.getRating());
	}

	@GetMapping("/users/{UserId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String UserId) {
		return ResponseEntity.ok(ratingService.getRatingByUserId(UserId));
	}

//	getbyHotelId
	@GetMapping("/hotels/{HotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String HotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotelId(HotelId));
	}

}
