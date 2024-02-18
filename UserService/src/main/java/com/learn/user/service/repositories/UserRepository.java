package com.learn.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.user.service.entites.User;

public interface UserRepository extends JpaRepository<User, String> {

}
