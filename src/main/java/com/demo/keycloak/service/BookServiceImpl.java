package com.demo.keycloak.service;

import com.demo.keycloak.adapter.BookCreateRequest;
import com.demo.keycloak.adapter.BookDto;
import com.demo.keycloak.entity.Book;
import com.demo.keycloak.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(BookCreateRequest request) {
        Book book = toBook(request);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public List<BookDto> list() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(x -> new BookDto(x.getId(), x.getName(), x.getWriterName(), x.getAmount()))
                .collect(Collectors.toList());
    }

    private Book toBook(BookCreateRequest request) {
        return Book.builder()
                    .id(UUID.randomUUID().toString())
                    .name(request.getName())
                    .writerName(request.getWriterName())
                    .amount(request.getAmount())
                    .createDate(LocalDateTime.now()).build();
    }
}


