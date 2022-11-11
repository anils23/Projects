package com.te.ems.service;

import java.util.List;

import com.te.ems.entity.Employee;
import com.te.ems.request.EmployeeRequest;

public interface EmployeeService {

	Employee addEmployeeDetails(EmployeeRequest employeeRequest);

	Employee updateEmployeeDetails(EmployeeRequest employeeRequest);

	Employee getEmployeeDetails(Integer employeeId);

	List<Employee> getAllEmployeeDetails();

	String deleteEmployeeDetails(Integer employeeId);

}
