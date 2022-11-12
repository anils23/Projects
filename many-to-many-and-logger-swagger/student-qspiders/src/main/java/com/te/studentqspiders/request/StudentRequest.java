package com.te.studentqspiders.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.te.studentqspiders.entity.Qspiders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class StudentRequest {

	private Integer studentId;

	private String studentName;

	private List<Integer> qspidersId;
	
	private List<Qspiders> qspiders;
}
