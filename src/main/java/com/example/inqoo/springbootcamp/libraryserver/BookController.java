package com.example.inqoo.springbootcamp.libraryserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RestController
public class BookController {

    private final RestTemplate restTemplate;
    private List<Book> books = new ArrayList<>();

    public BookController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    void addBook(@RequestBody Book book){

        Optional<Book> byIsbn = findByIsbn(book.getIsbn());
        if (byIsbn.isEmpty()){
            books.add(book);
        }
    }

    @GetMapping
    Book getBookByIsbn(@RequestParam String isbn){

        Optional<Book> result = findByIsbn(isbn);

        return result.orElse(null);
    }

    private Optional<Book> findByIsbn(@RequestParam String isbn) {
        return books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .findFirst();
    }

    @GetMapping("/{author}")
    List<Book> getBookByAuthor (@PathVariable String author) {

        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @GetMapping("/books")
    List<Book> getAllBooks (){
        return books;
    }
}