package com.springboot.student_registration.serviceInterface;

import java.util.List;

import com.springboot.student_registration.entity.Student;

public interface StudentServiceInterface {

	public Student findById(int theId);

	public List<Student> findAll();

	public Student save(Student student);

	public void deleteById(int id);

}