package com.registration_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration_app.model.User;
import com.registration_app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
    	if(repo.existsByEmail(user.getEmail())) {
    		throw new RuntimeException("Email already exists");
    	}
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    public void deleteUser(String id) {
        repo.deleteById(id);
    }
}
