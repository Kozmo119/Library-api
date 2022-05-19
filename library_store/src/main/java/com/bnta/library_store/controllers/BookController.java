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

    //Index mapping - display all books - GET - /books
//    @GetMapping
//    public ResponseEntity<List<Book>> getBooks() {
//        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
//    }



//                                                             /books?author=""
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooksAndFilters(
            @RequestParam(required = false, name = "author") String author
    )   {
        if(author !=null){
            return new ResponseEntity<>(bookRepository.findBookByAuthor(author), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }


    // Show mapping - get info of one book via its id - GET - /books/:id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }

    // Create mapping - add new book to database then redirect - POST -/books
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook){
        bookRepository.save(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // Destroy mapping - delete specific book via its id and redirect - DELETE - /books/:id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Optional<Book>> deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }


}


