package com.te.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.request.EmployeeRequest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeRequestTest {

	@Autowired
	private ObjectMapper mapper;

	@BeforeEach
	void setup() {

		mapper = new ObjectMapper();
	}

	@Test
	void testEmployeeRequest() throws JsonProcessingException {

		EmployeeRequest employee = EmployeeRequest.builder().firstName("Anil").email("anil@gmail.com").lastName("Thapa")
				.build();

		String valueAsString = mapper.writeValueAsString(employee);
		EmployeeRequest readValue = mapper.readValue(valueAsString, EmployeeRequest.class);
		String jsonValue = mapper.writeValueAsString(readValue);
		// Serialized object comparing
		assertEquals(valueAsString, jsonValue);
		// Deserialized object comparing
		assertEquals("Anil",employee.getFirstName());

	}

}