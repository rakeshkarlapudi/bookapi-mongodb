package com.example.bookapi.controller;

import com.example.bookapi.dto.BookRequestDTO;
import com.example.bookapi.dto.BookResponseDTO;
import com.example.bookapi.entity.Book;
import com.example.bookapi.service.BookService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {

        List<BookResponseDTO> books = bookService.getAllBooks()
                .stream()
                .map(book -> new BookResponseDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(
            @Valid @RequestBody BookRequestDTO request) {

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());

        Book savedBook = bookService.saveBook(book);

        BookResponseDTO response = new BookResponseDTO(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor(),
                savedBook.getPrice()
        );

        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(
            @PathVariable String id,
            @Valid @RequestBody BookRequestDTO request) {

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());

        Book updatedBook = bookService.updateBook(id, book);

        BookResponseDTO response = new BookResponseDTO(
                updatedBook.getId(),
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getPrice()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}