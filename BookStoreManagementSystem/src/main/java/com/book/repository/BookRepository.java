package com.book.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Custom finder methods
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
}