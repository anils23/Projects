package com.te.ems.request;

import java.util.List;

import com.te.ems.entity.Address;
import com.te.ems.entity.BankAccount;
import com.te.ems.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
	
	private Integer employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private Long phoneNumber;

	private Integer age;

	private Double salary;

	private String experience;

	private List<Address> address;

	private List<Department> department;

	private List<BankAccount> bankAccount;

}
