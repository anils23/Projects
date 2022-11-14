package com.example.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.request.UsersDTO;
import com.example.lms.response.Response;
import com.example.lms.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<Response> addUsers(@RequestBody UsersDTO request) {
		UsersDTO usersResquest = userService.addUsers(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message("User added successfully").data(usersResquest).build());
	}
}
