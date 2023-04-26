package com.springboot.student_registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.student_registration.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
