package com.demo.keycloak.service;

import com.demo.keycloak.port.BookCreateRequest;
import com.demo.keycloak.port.BookDto;
import com.demo.keycloak.entity.Book;

import java.util.List;

public interface BookService {
    Book create(BookCreateRequest request);
    List<BookDto> list();
}
