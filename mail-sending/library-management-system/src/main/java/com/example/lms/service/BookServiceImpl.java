package com.example.lms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Books;
import com.example.lms.repository.BookRepository;
import com.example.lms.request.BooksDTO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BooksDTO addBooks(BooksDTO request) {

		Books books = new Books();
		BeanUtils.copyProperties(request, books);
		books.setBookAvailibility(true);
		Books save = bookRepository.save(books);

		return BooksDTO.builder().bookAvailibility(save.getBookAvailibility()).bookId(save.getBookId()).bookName(save.getBookName()).authorName(save.getAuthorName())
				.bookDescription(save.getBookDescription()).costPerHour(save.getCostPerHour()).build();

	}

}
