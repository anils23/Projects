package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.te.resumebuilder.constant.ProfileConstant.HERE_IS_YOUR_DATA;

import com.te.resumebuilder.request.ProfileRequest;
import com.te.resumebuilder.response.Response;
import com.te.resumebuilder.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
public class ProfileController {

	@Autowired
	private  ProfileService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/save-resume")
	public ResponseEntity<Response> addResumes(@RequestBody ProfileRequest request) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.FALSE).message(HERE_IS_YOUR_DATA).data(service.addResumes(request)).build());
	}

	@GetMapping("/get-all-resume-by-employeeId/{employeeId}")
	public ResponseEntity<Response> getResumesByEmployeeId(@PathVariable("employeeId") String employeeId) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.FALSE).message(HERE_IS_YOUR_DATA).data(service.getResumeByEmployeeId(employeeId)).build());
	}
	
	@GetMapping("/get-resume-by-resumeId-and-employeeId/{resumeId},{employeeId}")
	public ResponseEntity<Response> getResumesByResumeId(@PathVariable("resumeId") String resumeId,@PathVariable("employeeId") String employeeId) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.FALSE).message(HERE_IS_YOUR_DATA).data(service.getResumeByResumeIdAndEmployeeId(resumeId, employeeId)).build());
	}
	
	@PutMapping("/update-resume-by-resumeId-and-employeeId")
	public ResponseEntity<Response> updateResumeByResumeIdAndEmployeeId(@RequestBody ProfileRequest request) {
		return ResponseEntity.ok(Response.builder().isError(Boolean.FALSE).message(HERE_IS_YOUR_DATA).data(service.updateResumeByResumeIdAndEmployeeId(request)).build());
	}

}
