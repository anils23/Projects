package com.te.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.controller.EmployeeController;
import com.te.ems.entity.Employee;
import com.te.ems.request.EmployeeRequest;
import com.te.ems.response.Response;
import com.te.ems.service.EmployeeService;

@SpringBootTest
class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController controller;

	@Mock
	private EmployeeService service;

	private MockMvc mvc;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	void testGetAllEmployees_success() throws Exception {
		List<Employee> list = Stream
				.of(Employee.builder().firstName("anil").build(), Employee.builder().firstName("sanjay").build())
				.toList();
		when(service.getAllEmployeeDetails()).thenReturn(list);
		String contentAsString = mvc.perform(get("/get-all-employee-details")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		Response response = objectMapper.readValue(contentAsString, Response.class);
		@SuppressWarnings("unchecked")
		List<Map<String, String>> emp = (List<Map<String, String>>) response.getData();
		assertEquals(list.get(0).getFirstName(), emp.get(0).get("firstName"));
	}

	@Test
	void testGetEmployeeDetailsByEmployeeId_success() throws Exception {
		Employee employee = Employee.builder().firstName("anil").lastName("thapa").build();
		when(service.getEmployeeDetails(1024)).thenReturn(employee);
		String string = mvc.perform(get("/get-employee-details/{employeeId}", 1024)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Response response = objectMapper.readValue(string, Response.class);
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) response.getData();
		assertEquals(employee.getFirstName(), map.get("firstName"));
	}

	@Test
	void testAddEmployeeDetails_success() throws Exception {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("anil").lastName("thapa").build();
		Employee employee = Employee.builder().firstName(employeeRequest.getFirstName())
				.lastName(employeeRequest.getLastName()).build();
		when(service.addEmployeeDetails(employeeRequest)).thenReturn(employee);
		String jsonObject = objectMapper.writeValueAsString(employeeRequest);
		String string = mvc
				.perform(post("/save-employee-details").contentType(MediaType.APPLICATION_JSON).content(jsonObject))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Response response = objectMapper.readValue(string, Response.class);
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) response.getData();
		assertEquals(employee.getFirstName(), map.get("firstName"));
	} 

	@Test
	void testUpdateEmployeeDetails_success() throws Exception {
		EmployeeRequest employeeRequest = EmployeeRequest.builder().firstName("anil").lastName("thapa").build();
		Employee employee = Employee.builder().firstName(employeeRequest.getFirstName())
				.lastName(employeeRequest.getLastName()).build();
		when(service.updateEmployeeDetails(employeeRequest)).thenReturn(employee);
		String jsonObject = objectMapper.writeValueAsString(employeeRequest);
		String string = mvc
				.perform(put("/update-employee-details").contentType(MediaType.APPLICATION_JSON).content(jsonObject))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Response response = objectMapper.readValue(string, Response.class);
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) response.getData();
		assertEquals(employee.getFirstName(), map.get("firstName"));
	}

	@Test
	void testDeleteEmployeeDetails_success() throws Exception {

		when(service.deleteEmployeeDetails(1024)).thenReturn("Deleted");
		String string = mvc.perform(delete("/delete-employee-details/{employeeId}", 1024)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Response response = objectMapper.readValue(string, Response.class);
		assertEquals("Deleted", response.getMessage());
	}
}