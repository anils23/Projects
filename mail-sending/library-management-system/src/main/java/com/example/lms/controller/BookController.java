package com.example.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.request.BooksDTO;
import com.example.lms.response.Response;
import com.example.lms.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add-books")
	public ResponseEntity<Response> addBooks(@RequestBody BooksDTO request) {
		BooksDTO books = bookService.addBooks(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message("Book added successfully").data(books).build());
	}
}
