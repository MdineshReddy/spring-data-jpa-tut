package com.dinesh.jdbcdemo.repository;


import com.dinesh.jdbcdemo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book, String>, PagingAndSortingRepository<Book, String> {

}
