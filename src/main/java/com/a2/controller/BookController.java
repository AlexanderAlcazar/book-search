package com.a2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.a2.entity.Book;
import com.a2.service.BookService;

// This class is the first stop for an incoming request.
// It receives the request from the client and passes it to the service layer.
@RestController
@RequestMapping("/books")
public class BookController {

    // Spring will provide the service object for us.
    @Autowired
    private BookService bookService;

    // This method handles a request to /books/search.
    // The controller receives the request and sends the work to the service.
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String searchTerm) {
        return bookService.searchBooks(searchTerm);
    }
    
}
