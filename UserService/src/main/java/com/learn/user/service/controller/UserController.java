package com.learn.user.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.user.service.entites.User;
import com.learn.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		System.out.println(" in user get one");
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		System.out.println("in user get all");
		List<User> allusers = userService.getAllUser();
		return ResponseEntity.ok(allusers);
	}
	
//	public ResponseEntity<Map<userId, user>> updateUser(String userId, User user){
//		User fetchedId = userService.getUser(userId);
//		fetchedId.
//		return 
//		
//	}

	@DeleteMapping
	public void deleteUser(String userId) {
		userService.deleteUser(userId);
	}

}
