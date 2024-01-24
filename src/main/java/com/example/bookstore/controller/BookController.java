package com.example.bookstore.controller;


import com.example.bookstore.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoint for getting all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Endpoint for getting a specific book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElse(null);
    }

    // Endpoint for adding a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // Endpoint for updating an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Set the ID to ensure the correct book is updated
        book.setId(id);
        return bookService.saveBook(book);
    }

    // Endpoint for deleting a book by ID
//    @DeleteMapping("/{id}")
//    public void deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//    }
}
