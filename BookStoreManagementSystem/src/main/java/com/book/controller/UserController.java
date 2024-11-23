package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.model.Book;
import com.book.service.BookService;

@Controller
	public class UserController {

	    @Autowired
	    private BookService bookService;

	    @GetMapping("/")
	    public String homePage(Model model) {
	        model.addAttribute("books", bookService.getAllBooks());
	        return "user/home";
	    }

	    @GetMapping("/buy/{id}")
	    public String buyBook(@PathVariable int id, Model model) {
	        Book book = bookService.getBookById(id);
	        model.addAttribute("book", book);
	        return "user/checkout";
	    }
	}




