package com.bnta.library_store.controllers;

import com.bnta.library_store.models.Book;
import com.bnta.library_store.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    // show mapping
    @GetMapping(value = "/{id}") // localhost:8080/books/1
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }

    // create
    @PostMapping
    public void createProduct(@RequestBody Book book){
        bookRepository.save(book);
    }
}

