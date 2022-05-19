package com.bnta.library_store.repositories;

import com.bnta.library_store.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByName(String name);

    List<Book> findBookByAuthor(String author);
}
