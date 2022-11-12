package com.te.studentqspiders.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.te.studentqspiders.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class QspidersRequest {
	
	private Integer qspidersId;

	private String qspidersBranch;

	private List<Integer> studentId;
	
	private List<Student> student;

}
