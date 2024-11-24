package com.book.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}