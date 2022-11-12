package com.te.studentqspiders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.studentqspiders.customexception.DetailsNotFoundException;
import com.te.studentqspiders.customexception.SomethingWentWrongException;
import com.te.studentqspiders.entity.Qspiders;
import com.te.studentqspiders.entity.Student;
import com.te.studentqspiders.repository.QspidersRepository;
import com.te.studentqspiders.repository.StudentRepository;
import com.te.studentqspiders.request.QspidersRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class QspidersServiceImpl implements QspidersService {

	private final QspidersRepository qspidersRepository;

	private final StudentRepository studentRepository;

	@Override
	public QspidersRequest addQspidersDetails(QspidersRequest request) {
		try {

			Qspiders qspiders = new Qspiders();
			qspiders.setQspidersBranch(request.getQspidersBranch());
			qspiders.setStudent(studentRepository.findAllById(request.getStudentId()));
			Qspiders save = qspidersRepository.save(qspiders);
			QspidersRequest qspidersRequest = new QspidersRequest();
			qspidersRequest.setQspidersId(save.getQspidersId());
			qspidersRequest.setQspidersBranch(save.getQspidersBranch());
			List<Student> student = save.getStudent();
			for (int i = 0; i < student.size(); i++) {
				student.get(i).setQspiders(null);
			}
			qspidersRequest.setStudent(student);
			log.info("Qspiders Created", qspidersRequest);
			return qspidersRequest;

		} catch (Exception e) {
			log.error("Something went Wrong");
			throw new SomethingWentWrongException();
		}
	}

	@Override
	public Qspiders getQspidersDetails(Integer qspidersId) {
		try {
			Optional<Qspiders> findById = qspidersRepository.findById(qspidersId);
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Qspiders qspiders = findById.get();
			List<Student> student = qspiders.getStudent();
			for (int i = 0; i < student.size(); i++) {
				student.get(i).setQspiders(null);
			}
			qspiders.setStudent(student);
			log.info("Qspiders deatils", qspiders);
			return qspiders;

		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (Exception e) {
			log.error("Something went Wrong");
			throw new SomethingWentWrongException();
		}

	}

	@Override
	public QspidersRequest updateQspiderDetails(QspidersRequest request) {
		try {

			Optional<Qspiders> findById = qspidersRepository.findById(request.getQspidersId());
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Qspiders qspiders = findById.get();
			qspiders.setQspidersBranch(request.getQspidersBranch());
			List<Integer> student = request.getStudentId();
			List<Student> newStudents = studentRepository.findAllById(student);
			List<Student> list = request.getStudent();
			list.addAll(newStudents);
			qspiders.setStudent(list);
			Qspiders save = qspidersRepository.save(qspiders);
			QspidersRequest qspidersRequest = new QspidersRequest();
			qspidersRequest.setQspidersId(save.getQspidersId());
			qspidersRequest.setQspidersBranch(save.getQspidersBranch());
			List<Student> studentlist = save.getStudent();
			for (int i = 0; i < studentlist.size(); i++) {
				studentlist.get(i).setQspiders(null);
			}
			qspidersRequest.setStudent(studentlist);
			log.info("Qspiders Updated", qspidersRequest);
			return qspidersRequest;

		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (Exception e) {
			log.error("Something went Wrong");
			throw new SomethingWentWrongException();
		}

	}

	@Override
	public String deleteQspiderDetails(Integer qspiderId) {
		try {

			Optional<Qspiders> findById = qspidersRepository.findById(qspiderId);
			if (!findById.isPresent()) {
				throw new DetailsNotFoundException();
			}
			Qspiders qspiders = findById.get();
			qspidersRepository.delete(qspiders);
			log.info("Qspiders Deleted", qspiders);
			return "Qspiders Deleted";

		} catch (DetailsNotFoundException e) {
			log.error("Details not found");
			throw e;
		} catch (Exception e) {
			log.error("Something went Wrong");
			throw new SomethingWentWrongException();
		}

	}

}
