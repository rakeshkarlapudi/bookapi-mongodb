package com.example.bookapi.service;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        logger.info("Saving new book: {}", book.getTitle());
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        logger.info("Deleting book with id {}", id);
        bookRepository.deleteById(id);
    }

    public Book updateBook(String id, Book bookDetails) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());

        logger.info("Updating book with id {}", id);
        return bookRepository.save(book);
    }
}