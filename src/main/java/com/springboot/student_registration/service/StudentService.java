package com.springboot.student_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.student_registration.entity.Student;
import com.springboot.student_registration.repo.StudentRepo;
import com.springboot.student_registration.serviceInterface.StudentServiceInterface;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student findById(int theId) {
		return this.studentRepo.findById(theId).orElseThrow(() -> new IllegalArgumentException("inavlid id"));
	}

	@Override
	public List<Student> findAll() {
		return this.studentRepo.findAll();
	}

	@Override
	public Student save(Student student) {
		return this.studentRepo.save(student);

	}

	@Override
	public void deleteById(int id) {
		this.studentRepo.deleteById(id);

	}

}
