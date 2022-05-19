package com.bnta.library_store.components;

import com.bnta.library_store.models.Book;
import com.bnta.library_store.models.Library;
import com.bnta.library_store.repositories.BookRepository;
import com.bnta.library_store.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Library library1 = new Library("John Barnes Library", "Holloway");
        libraryRepository.save(library1);

        Library library2 = new Library("Kentish Town Library of Things", "Kentish Town");
        libraryRepository.save(library2);

        Book book1 = new Book("The Lord Of The Rings", "John Tolkien", library1);
        bookRepository.save(book1);

        Book book2 = new Book("The Little Prince", " Antoine de Saint-Exupery", library1);
        bookRepository.save(book2);

        Book book3 = new Book("Harry Potter and the Philosopher’s Stone", "Joanne Rowling", library2);
        bookRepository.save(book3);

        Book book4 = new Book("Harry Potter and the Chamber of Secrets", "Joanne Rowling", library2);
        bookRepository.save(book4);

        Book book5 = new Book("Harry Potter and the Prisoner of Azkaban", "Joanne Rowling", library2);
        bookRepository.save(book5);


        Book book6 = new Book("Harry Potter and the Goblet of Fire", "Joanne Rowling", library2);
        bookRepository.save(book6);


        Book book7 = new Book("Harry Potter and the Order of the Phoenix ", "Joanne Rowling", library2);
        bookRepository.save(book7);


    }


}
