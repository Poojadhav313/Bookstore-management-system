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

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update a book
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete a book
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Find books by title
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    // Find books by author
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorContaining(author);
    }
}
