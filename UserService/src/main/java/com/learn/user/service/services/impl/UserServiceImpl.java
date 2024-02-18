package com.learn.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.learn.user.service.entites.Hotel;
import com.learn.user.service.entites.Rating;
import com.learn.user.service.entites.User;
import com.learn.user.service.exceptions.ResourceNotFoundException;
import com.learn.user.service.externalServices.HotelService;
import com.learn.user.service.repositories.UserRepository;
import com.learn.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with this user ID not found in sever!!"));
		Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
		logger.info("{}", ratingsOfUsers);

		List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();

		List<Rating> collect = ratings.stream().map(rating -> {
//			
//			RestTemplate Example
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//			Hotel body = forEntity.getBody();

//			Feign Client 
			Hotel body = hotelService.getHotel(rating.getHotelId());

			rating.setHotel(body);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratings);
		return user;
	}

	@Override
	public User updateUser(String userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userID) {

		userRepository.deleteById(userID);
	}

}
