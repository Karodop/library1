package com.example.inqoo.springbootcamp.libraryserver;

import java.time.LocalDate;

public class Book {

    private String isbn;

    public String getAuthor() {
        return author;
    }

    private String author;
    private String title;
    private LocalDate yearIfPublication;

    public Book(String isbn, String author, String title, LocalDate yearIfPublication) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.yearIfPublication = yearIfPublication;
    }
    public String getIsbn() {
        return this.isbn;
    }

}
