package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.model.Book;
import com.book.model.User;
import com.book.service.BookService;
import com.book.service.CartService;
import com.book.service.UserService;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, BookService bookService, UserService userService) {
        this.cartService = cartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    // View cart (fetching user details by ID)
    @GetMapping
    public String viewCart(Model model, @RequestParam int userId) {
        User user = userService.getUserById(userId); // Fetch user by ID
        cartService.getCartSummary(model, user);
        return "user/cart";  // Thymeleaf template for the cart page
    }

    // Add book to cart (using Book ID)
    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable("bookId") int bookId, @RequestParam int userId) {
        User user = userService.getUserById(userId); // Fetch user by ID
        if (user != null) {
            cartService.addToCart(bookId, user);
        }
        return "redirect:/cart?userId=" + userId;  // Redirect back to the cart page
    }

    // Remove book from cart (using Book ID)
    @PostMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable("bookId") int bookId, @RequestParam int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            cartService.removeFromCart(bookId, user);
        }
        return "redirect:/cart?userId=" + userId;  // Redirect back to the cart page
    }

    // Clear cart
    @PostMapping("/clear")
    public String clearCart(@RequestParam int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            cartService.clearCart(user);
        }
        return "redirect:/cart?userId=" + userId;  // Redirect back to the cart page
    }
}