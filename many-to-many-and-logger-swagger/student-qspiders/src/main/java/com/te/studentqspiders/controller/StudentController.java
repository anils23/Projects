
package com.te.studentqspiders.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.studentqspiders.entity.Student;
import com.te.studentqspiders.request.StudentRequest;
import com.te.studentqspiders.response.Response;
import com.te.studentqspiders.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;

	@PostMapping("/add-student-details")
	public ResponseEntity<Response> addStudentDetails(@RequestBody StudentRequest request) {
		log.info("Request for adding student details");
		StudentRequest student = service.addStudentDetails(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(student).build());
	}
	
	@GetMapping("/get-student-details/{studentId}")
	public ResponseEntity<Response> getStudentDetails(@PathVariable Integer studentId) {
		log.info("Request for getting student details");
		Student studentDetails = service.getStudentDetails(studentId);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(studentDetails).build());
	} 
	
	@DeleteMapping("/delete-student-details/{studentId}")
	public ResponseEntity<Response> deleteStudentDetails(@PathVariable Integer studentId) {
		log.info("Request for updating student details");
		String string = service.deleteStudentDetails(studentId);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message(string).build());
	} 
	
	@PutMapping("/update-student-details")
	public ResponseEntity<Response> upadteStudentDetails(@RequestBody StudentRequest request) {
		log.info("Request for deleting student details");
		StudentRequest student = service.updateStudentDetails(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(student).build());
	}


}
