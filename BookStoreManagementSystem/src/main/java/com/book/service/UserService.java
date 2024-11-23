package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.User;
import com.book.repository.UserRepository;

@Service
	public class UserService {

	    @Autowired
	    private UserRepository userRepository;

	    // Method to get user by username
	    public User getUserByUsername(String username) {
	        return userRepository.getUserByUsername(username);
	    }
	}




