package com.te.studentqspiders.service;

import com.te.studentqspiders.entity.Student;
import com.te.studentqspiders.request.StudentRequest;

public interface StudentService {

	StudentRequest addStudentDetails(StudentRequest request);

	Student getStudentDetails(Integer studentId);

	String deleteStudentDetails(Integer studentId);

	StudentRequest updateStudentDetails(StudentRequest request);

}
