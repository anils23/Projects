package com.te.ems.controller;

import static com.te.ems.constants.EmployeeContants.HERE_IS_YOUR_DATA;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.entity.Employee;
import com.te.ems.request.EmployeeRequest;
import com.te.ems.response.Response;
import com.te.ems.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;


	@PostMapping("/save-employee-details")
	public ResponseEntity<Response> addEmployeeDetails(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = employeeService.addEmployeeDetails(employeeRequest);
		return ResponseEntity.ok().body(Response.builder().isError(Boolean.FALSE).data(employee).build());
	}

	@PutMapping("/update-employee-details")
	public ResponseEntity<Response> updateEmployeeDetails(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = employeeService.updateEmployeeDetails(employeeRequest);
		return ResponseEntity.ok().body(Response.builder().isError(Boolean.FALSE).data(employee).build());
	}

//	@PreAuthorize("hasRole('USER')")
	@GetMapping("/get-employee-details/{employeeId}")
	public ResponseEntity<Response> getEmployee(@PathVariable Integer employeeId) {
		Employee employee = employeeService.getEmployeeDetails(employeeId);
		return ResponseEntity.ok(Response.builder().data(employee).isError(Boolean.FALSE).message(HERE_IS_YOUR_DATA).build());
	}

//	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/get-all-employee-details")
	public ResponseEntity<Response> getAllEmployeeDetails() {
		List<Employee> employeeDetails = employeeService.getAllEmployeeDetails();
		return ResponseEntity
				.ok(Response.builder().isError(Boolean.FALSE).data(employeeDetails).message(HERE_IS_YOUR_DATA).build());
	}
 
	@DeleteMapping("/delete-employee-details/{employeeId}")
	public ResponseEntity<Response> deleteEmployeeDetails(@PathVariable("employeeId") Integer employeeId) {
		String employee = employeeService.deleteEmployeeDetails(employeeId);
		return ResponseEntity.ok(Response.builder().isError(Boolean.FALSE).message(employee).build());

	}

}
