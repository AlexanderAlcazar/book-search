package com.a2.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.a2.entity.Book;

// This test checks the service layer's behavior.
// It verifies that invalid input is rejected and valid input produces results.
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    
    @Test
    void testSearchBooksWhenTermIsEmpty() {
        String searchTerm = "";
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm);
        });

    }
    @Test
    void testSearchBooksWhenTermIsNull() {
        String searchTerm = null;
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm);
        });
    }

    @Test
    void testSearchBooksWhenTermIsValid() {
        String searchTerm = "algorithms";
        List<Book> books = bookService.searchBooks(searchTerm);
        assert(!books.isEmpty());
    }
}
