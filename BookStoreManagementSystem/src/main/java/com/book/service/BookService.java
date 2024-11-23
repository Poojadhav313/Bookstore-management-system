package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
	public class BookService {

	    @Autowired
	    private BookRepository bookRepository;

	    // Method to get all books
	    public List<Book> getAllBooks() {
	        return bookRepository.getAllBooks();
	    }

	    // Method to add a new book
	    public int addBook(Book book) {
	        return bookRepository.addBook(book);
	    }

	    // Method to update a book
	    public int updateBook(Book book) {
	        return bookRepository.updateBook(book);
	    }

	    // Method to delete a book
	    public int deleteBook(int id) {
	        return bookRepository.deleteBook(id);
	    }

	    // Method to get book by ID
	    public Book getBookById(int id) {
	        return bookRepository.getBookById(id);
	    }
	}




