package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.model.Book;
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
}