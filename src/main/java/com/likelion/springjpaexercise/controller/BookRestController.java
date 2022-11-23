package com.likelion.springjpaexercise.controller;

import com.likelion.springjpaexercise.domain.dto.BookResponse;
import com.likelion.springjpaexercise.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable){
        List<BookResponse> bookResponses = bookService.findBooks(pageable);
        return ResponseEntity.ok().body(bookResponses);

    }
}
