package com.bnta.library_store.controllers;

import com.bnta.library_store.models.Book;
import com.bnta.library_store.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping //localhost:8080/pets
    public ResponseEntity<List<Book>> getAllBookssAndFilters(
            @RequestParam(required = false, name = "name") String name
    ){
        if(name != null){
            return new ResponseEntity<>(bookRepository.findBookByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }



    //    SHOW
    @GetMapping(value = "/{id}") // localhost:8080/books/1
    public ResponseEntity<Optional<Book>> getPet(@PathVariable Long id){
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }

    //    POST
    @PostMapping // POST localhost:8080/books
    public ResponseEntity<Book> createBook(@RequestBody Book newBook){
        bookRepository.save(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);

    }


}

