package com.bnta.library_store.repositories;

import com.bnta.library_store.models.Book;
import com.bnta.library_store.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByName(String name);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByNameContaining(String infix);

//    List<Book> findBookByNameAndLibrary(String name, Library library);
}
