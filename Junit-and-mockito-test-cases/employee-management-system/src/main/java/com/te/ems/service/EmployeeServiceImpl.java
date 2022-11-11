package com.te.ems.service;

import static com.te.ems.constants.EmployeeContants.EMPLOYEE_DELETED_SUCCESSFULLY;
import static com.te.ems.constants.EmployeeContants.EMPLOYEE_DETAILS_NOT_FOUND;
import static com.te.ems.constants.EmployeeContants.SOMETHING_WENT_WRONG;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.te.ems.customexception.EmployeeNotFoundException;
import com.te.ems.customexception.SomethingWentWrongException;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;
import com.te.ems.request.EmployeeRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private JavaMailSender mailSender;
	
	@Override
	public Employee addEmployeeDetails(EmployeeRequest employeeRequest) {
		try {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeRequest, employee);

//			SimpleMailMessage mail = new SimpleMailMessage();
//			mail.setFrom("anilsthapa07@gmail.com");
//			mail.setTo(employee.getEmail());
//			mail.setText("Welcome To Techno Elevate " + employee.getFirstName() + " " + employee.getLastName());
//			mail.setSubject("Sending mail using java application");
//			mailSender.send(mail);
			return employeeRepository.save(employee);
		} catch (RuntimeException exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public Employee updateEmployeeDetails(EmployeeRequest employeeRequest) {
		try {
			Employee employee = employeeRepository.findById(employeeRequest.getEmployeeId())
					.orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_DETAILS_NOT_FOUND));
			BeanUtils.copyProperties(employeeRequest, employee);
			return employeeRepository.save(employee);
			
		} catch (RuntimeException exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public Employee getEmployeeDetails(Integer employeeId) {
		try {
			return employeeRepository.findById(employeeId)
					.orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_DETAILS_NOT_FOUND));
		} catch (RuntimeException exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		try {
			return employeeRepository.findAll();
		} catch (RuntimeException exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public String deleteEmployeeDetails(Integer employeeId) {
		try {
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_DETAILS_NOT_FOUND));
			employeeRepository.delete(employee);
			return EMPLOYEE_DELETED_SUCCESSFULLY;
		} catch (RuntimeException exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG);
		}
	}


}
