package com.demo.keycloak.controller;

import com.demo.keycloak.port.ApiResponse;
import com.demo.keycloak.port.BookCreateRequest;
import com.demo.keycloak.port.BookDto;
import com.demo.keycloak.entity.Book;
import com.demo.keycloak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody BookCreateRequest request) {
        Book book = bookService.create(request);
        return ResponseEntity.ok(new ApiResponse(true, book.getId()));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<BookDto> books = bookService.list();
        return ResponseEntity.ok(books);
    }
}
