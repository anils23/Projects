package com.example.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.request.AdminDTO;
import com.example.lms.response.Response;
import com.example.lms.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add-admin")
	public ResponseEntity<Response> addAdmin(@RequestBody AdminDTO request) {
		AdminDTO adminRequest = adminService.addAdmin(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message("Admin added successfully").data(adminRequest).build());
	}

}
