package com.example.lms.request;

import java.util.List;

import com.example.lms.entity.Books;
import com.example.lms.entity.Notifications;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class UsersDTO {

	private Integer userId;

	private String userName;

	private Double accountBalance;
	
	private String emailId;

	private List<Notifications> notifications;

	private List<Books> books;

}
