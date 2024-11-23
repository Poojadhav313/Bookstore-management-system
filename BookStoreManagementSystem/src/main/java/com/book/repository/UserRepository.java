package com.book.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.model.User;

@Repository
	public class UserRepository {

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    // Method to find a user by username
	    @SuppressWarnings("deprecation")
		public User getUserByUsername(String username) {
	        String sql = "SELECT * FROM users WHERE username = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setRole(rs.getString("role"));
	            return user;
	        });
	    }
	}


