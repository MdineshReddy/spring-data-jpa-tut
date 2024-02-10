package com.dinesh.jdbcdemo.controller;

import com.dinesh.jdbcdemo.model.Book;
import com.dinesh.jdbcdemo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService){
        this.bookService = bookService;
    }

//    now you will be able to send request with page and size params as http://localhost:8080/books?page=2&size=5
    @GetMapping("/books")
    public ResponseEntity<Page<Book>> listBooks(Pageable pageable){
        return new ResponseEntity<Page<Book>>(bookService.getBooks(pageable), HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
     return bookService.getBookByIsbn(isbn).map(book -> new ResponseEntity<>(book, HttpStatus.OK))
             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
