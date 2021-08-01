package com.test.astracassandraapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.astracassandraapp.model.Student;
import com.test.astracassandraapp.repo.TestRepository;

@RestController
public class TestController {

	@Autowired
	TestRepository repo;

	@GetMapping("/test")
	public void testDBOps() {
		// template.insert(new Student(1, "Soumav", 30));
		repo.save(new Student(2, "Soumav2", 30));
		System.out.println("Saved!");
	}

}
