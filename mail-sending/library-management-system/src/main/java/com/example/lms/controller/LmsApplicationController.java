package com.example.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.request.BooksDTO;
import com.example.lms.request.LmsApplicationDTO;
import com.example.lms.response.Response;
import com.example.lms.service.LmsApplicationService;

@RestController
public class LmsApplicationController {
	
	@Autowired
	private LmsApplicationService lmsApplicationService;
	
	@GetMapping("/get-all-books-by-name/{bookName}")
	public ResponseEntity<Response> getAllBooksByName(@PathVariable String bookName) {
	      List<BooksDTO> allBooksByName = lmsApplicationService.getAllBooksByName(bookName);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message("All the books with the name").data(allBooksByName).build());
	}
	
	@PostMapping("/issue-book-to-user")
	public ResponseEntity<Response> issueBookToUser(@RequestBody LmsApplicationDTO lmsApplicationDTO) {
	      String string = lmsApplicationService.issueBookToUser(lmsApplicationDTO);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message(string).build());
	}
	
	@PostMapping("/change-book-availability")
	public ResponseEntity<Response> changeBookAvailability(@RequestParam Boolean bookAvailability, Integer bookId) {
	    String availability = lmsApplicationService.changeBookAvailability(bookAvailability, bookId);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message(availability).build());
	}
}
