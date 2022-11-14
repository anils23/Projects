package com.example.lms.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.lms.customexception.BookNotAvailableException;
import com.example.lms.customexception.BookNotFoundException;
import com.example.lms.customexception.InsufficientAccountBalanceException;
import com.example.lms.customexception.UserNotFoundException;
import com.example.lms.entity.Admin;
import com.example.lms.entity.Books;
import com.example.lms.entity.Notifications;
import com.example.lms.entity.Users;
import com.example.lms.repository.AdminRepository;
import com.example.lms.repository.BookRepository;
import com.example.lms.repository.NotificationRepository;
import com.example.lms.repository.UserRespository;
import com.example.lms.request.BooksDTO;
import com.example.lms.request.LmsApplicationDTO;

@Service
public class LmsApplicationServiceImpl implements LmsApplicationService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRespository userRespository;

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<BooksDTO> getAllBooksByName(String bookName) {

		List<Books> list = bookRepository.findAllByBookName(bookName);
		if (list.isEmpty()) {
			throw new BookNotFoundException("Sorry buddy no book with this name");
		}

		return list.stream().map(e -> BooksDTO.builder().bookAvailibility(e.getBookAvailibility()).bookId(e.getBookId())
						.bookName(e.getBookName()).bookDescription(e.getBookDescription())
						.costPerHour(e.getCostPerHour()).users(e.getUsers().stream().map(Users::getUserName).toList()).build()).toList();

	}

	@Override
	public String issueBookToUser(LmsApplicationDTO lmsApplicationDTO) {
		try {

			Books books = bookRepository.findById(lmsApplicationDTO.getBookId()).orElseThrow(
					() -> new BookNotFoundException("Book Not Found with Id : " + lmsApplicationDTO.getBookId()));

			if (!books.getBookAvailibility()) {
				throw new BookNotAvailableException("Sorry this book is not available");
			}

			Users user = userRespository.findById(lmsApplicationDTO.getUserId()).orElseThrow(
					() -> new UserNotFoundException("User Not Found with Id : " + lmsApplicationDTO.getUserId()));
			List<Admin> allAdminList = adminRepository.findAll();

			Notifications notifications = new Notifications();
			notifications.setMessage("Book Issued to " + lmsApplicationDTO.getUserName());
			notifications.setUsers(user);

			Double totalAmount = lmsApplicationDTO.getBooksNeededForHowManyHours() * books.getCostPerHour();
			if (user.getAccountBalance() < totalAmount) {
				throw new InsufficientAccountBalanceException("Sorry buddy insufficient amount, Please add some money");
			}
			user.setAccountBalance(user.getAccountBalance() - totalAmount);

			Iterator<Admin> iterator = allAdminList.iterator();
			while (iterator.hasNext()) {
				Admin admin = iterator.next();
				admin.setAccountBalance(admin.getAccountBalance() + totalAmount);
				adminRepository.save(admin);
				notifications.setAdmin(admin);
			}

			books.setBookAvailibility(false);

			books.getUsers().add(user);
			user.getBooks().add(books);
			
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setFrom("${spring.mail.username}");
			mail.setTo(user.getEmailId());
			mail.setText("Hii buddy book is issued to u "+ books.getBookName());
			mail.setSubject("mail sending");
			mailSender.send(mail);

			notificationRepository.save(notifications);
			bookRepository.save(books);
			userRespository.save(user);

			return "Book Issued Successfully";	

		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public String changeBookAvailability(Boolean bookAvailability, Integer bookId) {
		Books book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book Not Found with Id : " + bookId));
		book.setBookAvailibility(bookAvailability);
		bookRepository.save(book);
		return "Book availability updated successfully";
	}

}
