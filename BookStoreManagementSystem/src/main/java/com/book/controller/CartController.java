package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.book.model.Book;
import com.book.model.User;
import com.book.service.BookService;
import com.book.service.CartService;
import com.book.service.UserService;
@Controller
@RequestMapping("/user/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private UserService userService;

    // View the cart - This method will handle GET requests to /user/cart/{userId}
	/*
	 * @GetMapping("/{userId}") public String viewCart(@PathVariable("userId") int
	 * userId, Model model) { User user = userService.getUserById(userId); if (user
	 * != null) { cartService.getCartSummary(model, user); // Add cart summary to
	 * model } return "user/cart"; // Thymeleaf template for the cart page }
	 */

    // Clear cart - Update the URL mapping to avoid conflict
    @PostMapping("/clearCart/{userId}")  // Unique URL
    public String clearCart(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            cartService.clearCart(user);  // Clear the user's cart
        }
        return "redirect:/user/cart/" + userId; // Redirect back to the cart page
    }

    @Autowired
    private BookService bookService;
    
 // Add book to cart
 // Add book to cart
    @PostMapping("/add/{userId}/{bookId}")
    public String addToCart(@PathVariable("userId") int userId, @PathVariable("bookId") int bookId) {
        // Fetch user by ID
        User user = userService.getUserById(userId);
        
        // Fetch the book by ID
        Book book = bookService.getBookById(bookId);
        
        // If both the user and the book exist, add the book to the user's cart
        if (user != null && book != null) {
            cartService.addToCart(bookId, user); // Add the book to the cart
        }

        // Redirect to the user's cart page
        return "redirect:/user/cart/" + userId; 
    }



    // Remove book from cart
    @PostMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable("bookId") int bookId, @RequestParam int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            cartService.removeFromCart(bookId, user);  // Remove book from cart
        }
        return "redirect:/user/cart/" + userId;  // Redirect back to the cart page
    }
}
