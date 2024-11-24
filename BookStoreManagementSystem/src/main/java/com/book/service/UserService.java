package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.User;
import com.book.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public void registerUser(User user) {
        userRepository.save(user);
    }

    // Get user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Get user by ID
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    // Update user (to save changes to the cart)
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
