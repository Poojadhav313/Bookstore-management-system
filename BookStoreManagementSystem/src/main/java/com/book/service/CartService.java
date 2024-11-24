package com.book.service;

import com.book.model.Book;
import com.book.model.Cart;
import com.book.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
        cart.addBook(bookId);
    }

    // Remove a book from the cart using its ID
    public void removeFromCart(int bookId, User user) {
        Cart cart = user.getCart();
        cart.removeBook(bookId);
    }

    // Get cart details (including Book objects) and add it to the model
    public void getCartSummary(Model model, User user) {
        Cart cart = user.getCart();
        Set<Integer> bookIds = cart.getBookIds();
        double totalPrice = 0.0;
        Set<Book> booksInCart = new HashSet<>();
        
        for (Integer bookId : bookIds) {
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                booksInCart.add(book);
                totalPrice += book.getPrice();
            }
        }

        model.addAttribute("books", booksInCart);  // List of books in cart
        model.addAttribute("totalPrice", totalPrice);  // Total price of books in the cart
    }

    // Clear the cart
    public void clearCart(User user) {
        Cart cart = user.getCart();
        cart.clear();
    }
}