package com.example.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {
	
	List<Books> findAllByBookName(String bookName);

}
