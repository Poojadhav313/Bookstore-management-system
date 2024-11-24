package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.book.model.Book;
import com.book.model.Cart;
import com.book.model.User;
import com.book.service.BookService;
import com.book.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    // Home page with book list
    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "user/home";
    }

    // View book details
    @GetMapping("/book/{id}")
    public String getBookDetails(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "user/bookDetails";
    }

    // Login page
    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }

    // Register page
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    // Process user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    // Login logic (authentication will be implemented)
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "redirect:/user/home";
        }
        return "redirect:/user/login";
    }

    // Add book to the cart
    @PostMapping("/cart/add/{bookId}")
    public String addToCart(@PathVariable("bookId") int bookId, @RequestParam("userId") int userId, Model model) {
        Book book = bookService.getBookById(bookId);
        User user = userService.getUserById(userId);
        if (user != null && book != null) {
            user.addToCart(book);  // Add book to user's cart
            userService.updateUser(user);  // Update user to persist their data (without cart)
        }
        return "redirect:/user/cart/" + userId;
    }

    // Get user's cart
    @GetMapping("/cart/{userId}")
    public String viewCart(@PathVariable("userId") int userId, Model model) {
        User user = userService.getUserById(userId);
        if (user != null) {
            Cart cart = user.getCart();
            List<Book> cartBooks = cart.getBooks();
            double totalPrice = cart.getTotalPrice();
            model.addAttribute("books", cartBooks);
            model.addAttribute("totalPrice", totalPrice);
        }
        return "user/cart";
    }


    // Remove book from cart
	/*
	 * @PostMapping("/cart/remove/{bookId}") public String
	 * removeFromCart(@PathVariable("bookId") int bookId, @RequestParam("userId")
	 * int userId) { User user = userService.getUserById(userId); if (user != null)
	 * { user.getCart().removeIf(book -> book.getId() == bookId);
	 * userService.updateUser(user); // Save the updated user with the modified cart
	 * } return "redirect:/user/cart/" + userId; }
	 */

    // Clear the cart
    @PostMapping("/cart/clear/{userId}")
    public String clearCart(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.getCart().clearCart();  // Clear the cart
            userService.updateUser(user);
        }
        return "redirect:/user/cart/" + userId;
    }
}
