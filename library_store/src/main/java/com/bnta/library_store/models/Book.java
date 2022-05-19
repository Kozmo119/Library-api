package com.bnta.library_store.models;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String author;


    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    public Book(String name, String author, Library library) {
        this.name = name;
        this.author = author;
        this.library = library;
    }

    public Book(){}

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
