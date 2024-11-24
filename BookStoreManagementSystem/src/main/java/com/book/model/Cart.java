package com.book.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.book.service.BookService;

public class Cart {
    // Store book IDs (instead of Book objects)
    private Set<Integer> bookIds = new HashSet<>();

    // Add a book by its ID
    public void addBook(int bookId) {
        bookIds.add(bookId);
    }

    // Remove a book by its ID
    public void removeBook(int bookId) {
        bookIds.remove(bookId);
    }

    // Get the set of book IDs in the cart
    public Set<Integer> getBookIds() {
        return bookIds;
    }

    // Get the total price of books in the cart
    public double getTotalPrice(BookService bookService) {
        double totalPrice = 0.0;
        for (Integer bookId : bookIds) {
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                totalPrice += book.getPrice();
            }
        }
        return totalPrice;
    }

    // Clear the cart
    public void clear() {
        bookIds.clear();
    }
}