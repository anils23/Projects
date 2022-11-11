package com.te.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.entity.User;
import com.te.ems.request.UserRequest;
import com.te.ems.response.Response;
import com.te.ems.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<Response> addUser(@RequestBody UserRequest request){
		User user = userService.addUser(request);
		return ResponseEntity.ok().body(Response.builder().isError(Boolean.FALSE).data(user).build());
	}

}
