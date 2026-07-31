package com.a2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.a2.entity.Book;

// This class is responsible for talking to the database.
// It is the data-access layer, so it handles retrieving or saving information.
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM books WHERE search_vector @@ to_tsquery(:searchTerm)", nativeQuery = true)
    List<Book> searchBooks(@Param("searchTerm") String searchTerm);
}
