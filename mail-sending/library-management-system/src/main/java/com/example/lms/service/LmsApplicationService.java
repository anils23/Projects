package com.example.lms.service;

import java.util.List;

import com.example.lms.request.BooksDTO;
import com.example.lms.request.LmsApplicationDTO;

public interface LmsApplicationService {

	List<BooksDTO> getAllBooksByName(String bookName);

	String issueBookToUser(LmsApplicationDTO lmsApplicationDTO);

	String changeBookAvailability(Boolean bookAvailability, Integer bookId);

}
