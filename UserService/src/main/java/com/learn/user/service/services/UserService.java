package com.learn.user.service.services;

import java.util.List;

import com.learn.user.service.entites.User;

public interface UserService {

//	Create user
	User saveUser(User user);

//	Get All user
	List<User> getAllUser();

//	get single user of the given UserId
	User getUser(String userId);

	User updateUser(String userId, User user);

//	ToDo Update and delete 
	void deleteUser(String userID);

}
