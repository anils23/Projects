package com.te.studentqspiders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.studentqspiders.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
