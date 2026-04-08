package com.registration_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.registration_app.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	boolean existsByEmail(String email);
}