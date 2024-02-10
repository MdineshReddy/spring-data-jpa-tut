package com.dinesh.jdbcdemo.service;

import com.dinesh.jdbcdemo.model.Book;
import com.dinesh.jdbcdemo.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Optional<Book> getBookByIsbn(String isbn){
        return bookRepository.findById(isbn);
    }

}
