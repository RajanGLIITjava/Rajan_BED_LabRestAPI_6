package com.springboot.student_registration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.student_registration.entity.Role;
import com.springboot.student_registration.entity.Student;
import com.springboot.student_registration.entity.User;
import com.springboot.student_registration.repo.StudentRepo;
import com.springboot.student_registration.repo.UserRepo;

@Configuration
public class BootstrapData {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// student table data
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void initializeData(ApplicationReadyEvent readyEvent) {
		Student Suresh = new Student("Suresh", "Reddy", "B.Tech", "India");
		Student Marali = new Student("Marali", "Mohan", "B.Arch", "Canada");
		Student Daniel = new Student("Daniel", "Denson", "B.Tech", "New Zealand");
		Student Tanya = new Student("Tanya", "Gupta", "B.Com", "USA");

		this.studentRepo.save(Suresh);
		this.studentRepo.save(Marali);
		this.studentRepo.save(Daniel);
		this.studentRepo.save(Tanya);
	}

	// users and admin roles
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void initializeUsersData(ApplicationReadyEvent readyEvent) {
		User USER = new User("USER", passwordEncoder.encode("USER"));
		User ADMIN = new User("ADMIN", passwordEncoder.encode("ADMIN"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");

		USER.addRole(userRole);

		ADMIN.addRole(adminRole);

		this.userRepo.save(ADMIN);
		this.userRepo.save(USER);
	}
}
