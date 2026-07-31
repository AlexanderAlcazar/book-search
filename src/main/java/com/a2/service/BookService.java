package com.a2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2.entity.Book;
import com.a2.repository.BookRepository;

// This class contains the main business logic of the application.
// The controller receives the request, but the service is where the real behavior lives.
@Service
public class BookService {
    // Spring provides the repository object so this service can talk to the database.
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be null or empty");
        }
        return bookRepository.searchBooks(searchTerm);
    }
}
