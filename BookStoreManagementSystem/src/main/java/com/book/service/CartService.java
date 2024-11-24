package com.book.service;

import com.book.model.Book;
import com.book.model.Cart;
import com.book.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CartService {

    private final BookService bookService;

    @Autowired
    public CartService(BookService bookService) {
        this.bookService = bookService;
    }

    // Add a book to the cart using its ID
    public void addToCart(int bookId, User user) {
        Cart cart = user.getCart();
        Book book = bookService.getBookById(bookId); // Retrieve book by ID
        if (book != null) {
            cart.addBook(book); // Add book to cart
        }
    }

    // Remove a book from the cart using its ID
    public void removeFromCart(int bookId, User user) {
        Cart cart = user.getCart();
        Book book = bookService.getBookById(bookId); // Retrieve book by ID
        if (book != null) {
            cart.removeBook(book); // Remove book from cart
        }
    }

    // Get cart details (including Book objects) and add it to the model
    public void getCartSummary(Model model, User user) {
        Cart cart = user.getCart();
        double totalPrice = cart.getTotalPrice();
        model.addAttribute("books", cart.getBooks()); // List of books in cart
        model.addAttribute("totalPrice", totalPrice);  // Total price of books in the cart
    }

    // Clear the cart
    public void clearCart(User user) {
        Cart cart = user.getCart();
        cart.clearCart(); // Call the clearCart method to remove all books
    }
}
