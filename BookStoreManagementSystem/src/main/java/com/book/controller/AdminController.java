package com.book.controller;

import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    // Admin dashboard
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/dashboard";
    }
    
    @GetMapping("/bookList")
    public String getall(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/bookList";
    }

    // Add book
    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());  
        return "admin/addBook"; 
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book); 
        return "redirect:/admin/dashboard";  
    }

    // Edit book
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") int id, Model model) {
    	 Book book = bookService.getBookById(id);
    	 model.addAttribute("book", book);
        return "admin/editBook";
    }

    @PostMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, @ModelAttribute("book") Book book) {
        book.setId(id);
        System.out.println(id);
        bookService.updateBook(book);
        return "redirect:/admin/dashboard";
    }

    // Delete book
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/admin/dashboard";
    }
}