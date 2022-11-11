package com.te.ems;

import static com.te.ems.constants.EmployeeContants.EMPLOYEE_DELETED_SUCCESSFULLY;
import static com.te.ems.constants.EmployeeContants.SOMETHING_WENT_WRONG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;
import com.te.ems.request.EmployeeRequest;
import com.te.ems.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@Mock
	EmployeeRepository repository;

	@InjectMocks
	EmployeeServiceImpl service;

	@Mock
	JavaMailSender mailSender;

	@Test
	void testGetAllemployeeDetails_success() throws Exception {
		when(repository.findAll()).thenReturn(
				Stream.of(Employee.builder().firstName("anil").build(), Employee.builder().firstName("sanjay").build())
						.toList());
		List<Employee> list = service.getAllEmployeeDetails();
		assertEquals(2, list.size());
	}

	@Test
	void testGetAllemployeeDetails_failure() throws Exception {
		when(repository.findAll()).thenThrow(RuntimeException.class);
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.getAllEmployeeDetails());
		assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
	}

	@Test
	void testGetEmployeeDetailsById_success() throws Exception {
		when(repository.findById(10005)).thenReturn(Optional.of(Employee.builder().firstName("anil").build()));
		Employee employee = service.getEmployeeDetails(10005);
		assertEquals("anil", employee.getFirstName());
	}

	@Test
	void testGetEmployeeDetailsById_failure() {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.getEmployeeDetails(10245));
		assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
	}

	@Test
	void testAddEmployeeDetails_success() throws Exception {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("dharshan").email("dsw7699@gmail.com")
				.lastName("buddy").build();
		Employee employee = Employee.builder().firstName(employeeRequest.getFirstName())
				.email(employeeRequest.getEmail()).lastName(employeeRequest.getLastName()).build();

		when(repository.save(employee)).thenReturn(employee);
		Employee employee2 = service.addEmployeeDetails(employeeRequest);
		assertEquals("dsw7699@gmail.com", employee2.getEmail());
	}

	@Test
	void testAddEmployeeDetails_failure() {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("dharshan").email("dsw7699@gmail.com")
				.lastName("buddy").build();
		when(repository.save(Mockito.any())).thenThrow(RuntimeException.class);
		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> service.addEmployeeDetails(employeeRequest));
		assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
	}

	@Test
	void testUpdateEmployeeDetails_success() throws Exception {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("dharshanwawale")
				.email("dsw7699@gmail.com").lastName("buddy").employeeId(1245).build();
		Employee employee = Employee.builder().firstName(employeeRequest.getFirstName())
				.email(employeeRequest.getEmail()).lastName(employeeRequest.getLastName()).build();

		when(repository.findById(employeeRequest.getEmployeeId())).thenReturn(Optional.of(employee));
		when(repository.save(employee)).thenReturn(employee);
		Employee employee2 = service.updateEmployeeDetails(employeeRequest);
		assertEquals("dharshanwawale", employee2.getFirstName());
	}

	@Test
	void testUpdateEmployeeDetails_failure() throws Exception {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("dharshanwawale")
				.email("dsw7699@gmail.com").lastName("buddy").employeeId(1256).build();
		RuntimeException exception = assertThrows(RuntimeException.class,
				() -> service.updateEmployeeDetails(employeeRequest));
		assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
	}

	@Test
	void testDeleteEmployeeDetails_success() throws Exception {
		Employee employee = Employee.builder().firstName("anil").email("anil@gmail.com").lastName("thapa")
				.employeeId(146).build();
		when(repository.findById(146)).thenReturn(Optional.of(employee));
		String string = service.deleteEmployeeDetails(employee.getEmployeeId());
		assertEquals(EMPLOYEE_DELETED_SUCCESSFULLY, string);
	}

	@Test
	void testDeleteEmployeeDetails_failure() throws Exception {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.deleteEmployeeDetails(7895));
		assertEquals(SOMETHING_WENT_WRONG, exception.getMessage());
	}

}