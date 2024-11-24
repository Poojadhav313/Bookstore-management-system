package com.book.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Book> books = new ArrayList<>();

    // Add a book to the cart
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Remove a book from the cart
    public void removeBook(Book book) {
        this.books.remove(book);
    }

    // Remove a book from the cart based on a condition (removeIf)
    public void removeIf(Book book) {
        this.books.removeIf(b -> b.getId() == book.getId()); // Remove by book ID
    }

    // Clear the cart
    public void clearCart() {
        this.books.clear(); // This is the standard List clear method
    }

    // Get the total price of all books in the cart
    public double getTotalPrice() {
        return books.stream().mapToDouble(Book::getPrice).sum();
    }

    // Getter for the books
    public List<Book> getBooks() {
        return books;
    }

    // Setter for the books
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
