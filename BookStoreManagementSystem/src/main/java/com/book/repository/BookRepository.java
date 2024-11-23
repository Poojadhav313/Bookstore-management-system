package com.book.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.model.Book;

@Repository
public class BookRepository {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    // Method to get all books
	    public List<Book> getAllBooks() {
	        String sql = "SELECT * FROM books";
	        return jdbcTemplate.query(sql, (rs, rowNum) -> {
	            Book book = new Book();
	            book.setId(rs.getInt("id"));
	            book.setTitle(rs.getString("title"));
	            book.setAuthor(rs.getString("author"));
	            book.setPrice(rs.getDouble("price"));
	            book.setDescription(rs.getString("description"));
	            return book;
	        });
	    }
    
	 // Method to get a book by ID
	    @SuppressWarnings("deprecation")
		public Book getBookById(int id) {
	        String sql = "SELECT * FROM books WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	            Book book = new Book();
	            book.setId(rs.getInt("id"));
	            book.setTitle(rs.getString("title"));
	            book.setAuthor(rs.getString("author"));
	            book.setPrice(rs.getDouble("price"));
	            book.setDescription(rs.getString("description"));
	            return book;
	        });
	    }
	    
	 // Method to add a new book
	    public int addBook(Book book) {
	        String sql = "INSERT INTO books (title, author, price, description) VALUES (?, ?, ?, ?)";
	        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription());
	    }

	    // Method to update an existing book
	    public int updateBook(Book book) {
	        String sql = "UPDATE books SET title = ?, author = ?, price = ?, description = ? WHERE id = ?";
	        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription(), book.getId());
	    }


	    // Method to delete a book
	    public int deleteBook(int id) {
	        String sql = "DELETE FROM books WHERE id = ?";
	        return jdbcTemplate.update(sql, id);
	    }


	

}
