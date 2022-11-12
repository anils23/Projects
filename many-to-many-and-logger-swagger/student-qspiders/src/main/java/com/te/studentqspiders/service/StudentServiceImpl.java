package com.te.studentqspiders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.te.studentqspiders.customexception.DetailsNotFoundException;
import com.te.studentqspiders.customexception.SomethingWentWrongException;
import com.te.studentqspiders.entity.Qspiders;
import com.te.studentqspiders.entity.Student;
import com.te.studentqspiders.repository.QspidersRepository;
import com.te.studentqspiders.repository.StudentRepository;
import com.te.studentqspiders.request.StudentRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final QspidersRepository qspidersRepository;

	@Override
	public StudentRequest addStudentDetails(StudentRequest request) {
		try {

			Student student = new Student();
			student.setStudentName(request.getStudentName());
			List<Qspiders> findAllById = qspidersRepository.findByQspidersIdIn(request.getQspidersId());
			List<Qspiders> collect = findAllById.stream().map(map -> {
				map.getStudent().add(student);
				return map;
			}).collect(Collectors.toList());
			student.setQspiders(collect);

			Student save = studentRepository.save(student);
			StudentRequest studentRequest = new StudentRequest();
			studentRequest.setStudentId(save.getStudentId());
			studentRequest.setStudentName(save.getStudentName());

			List<Qspiders> qspiders = save.getQspiders();
			for (int i = 0; i < qspiders.size(); i++) {
				qspiders.get(i).setStudent(null);
			}
			studentRequest.setQspiders(qspiders);
			log.info("Student Added", studentRequest);
			return studentRequest;

		} catch (Exception e) {
			log.error("Something went wrong");
			throw new SomethingWentWrongException();
		}
	}

	@Override
	public Student getStudentDetails(Integer studentId) {
		try {

			Optional<Student> findById = studentRepository.findById(studentId);
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Student student = findById.get();
			List<Qspiders> qspiders = student.getQspiders();
			for (int i = 0; i < qspiders.size(); i++) {
				qspiders.get(i).setStudent(null);
			}
			student.setQspiders(qspiders);
			log.info("Student Details", student);
			return student;
		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (Exception e) {
			log.error("Something went wrong");
			throw new SomethingWentWrongException();
		}
	}

	@Override
	public String deleteStudentDetails(Integer studentId) {
		try {

			Optional<Student> findById = studentRepository.findById(studentId);
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Student student = findById.get();

			List<Qspiders> findAll = qspidersRepository.findAll();
			for (int i = 0; i < findAll.size(); i++) {
				Qspiders qspiders = findAll.get(i);
				qspiders.getStudent().remove(student);
				qspidersRepository.save(qspiders);
			}
			studentRepository.delete(student);
			log.info("Student Deleted", student);
			return "Student Deleted";

		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (RuntimeException e) {
			log.error("Something went wrong");
			throw new SomethingWentWrongException();
		}
	}

	@Override
	public StudentRequest updateStudentDetails(StudentRequest request) {

		try {
			Optional<Student> findById = studentRepository.findById(request.getStudentId());
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Student student = findById.get();
			student.setStudentName(request.getStudentName());

			List<Qspiders> newQspiders = qspidersRepository.findAllById(request.getQspidersId());
			List<Qspiders> qspiders = request.getQspiders();
			qspiders.addAll(newQspiders);

			List<Qspiders> findAll = qspidersRepository.findAll();
			for (int i = 0; i < findAll.size(); i++) {
				Qspiders qspiders2 = findAll.get(i);
				qspiders2.getStudent().remove(student);
				qspidersRepository.save(qspiders2);
			}

			for (int i = 0; i < qspiders.size(); i++) {
				Qspiders qspiders2 = qspiders.get(i);
				if (qspiders2.getStudent() != null) {
					qspiders2.getStudent().add(student);
				} else {
					ArrayList<Student> arrayList = new ArrayList<>();
					arrayList.add(student);
					qspiders2.setStudent(arrayList);
				}
				qspidersRepository.save(qspiders2);
			}

			student.setQspiders(qspiders);

			Student save = studentRepository.save(student);
			StudentRequest studentRequest = new StudentRequest();
			studentRequest.setStudentId(save.getStudentId());
			studentRequest.setStudentName(save.getStudentName());

			List<Qspiders> qspiders2 = save.getQspiders();
			for (int i = 0; i < qspiders2.size(); i++) {
				qspiders2.get(i).setStudent(null);
			}
			studentRequest.setQspiders(qspiders2);
            log.info("Student details updated", studentRequest);
			return studentRequest;
		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (RuntimeException e) {
			log.error("Something went wrong");
			throw new SomethingWentWrongException();
		}

	}
}
