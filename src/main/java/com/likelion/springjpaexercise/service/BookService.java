package com.likelion.springjpaexercise.service;

import com.likelion.springjpaexercise.domain.dto.BookResponse;
import com.likelion.springjpaexercise.domain.entity.Book;
import com.likelion.springjpaexercise.repository.BookRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book -> BookResponse.of(book)).collect(Collectors.toList());
        return bookResponses;
    }

}
