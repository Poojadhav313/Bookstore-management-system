package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.model.Book;
import com.book.service.BookService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/bookList";
    }
    
    @GetMapping("/book/add")
    public String addBookForm() {
        return "admin/addBook";
    }

    @PostMapping("/book/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/book/edit/{id}")
    public String editBookForm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "admin/editBook";
    }
    
    @PostMapping("/book/edit/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }
 
}




