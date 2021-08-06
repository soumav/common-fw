package com.test.astracassandraapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.astracassandraapp.model.Student;
import com.test.astracassandraapp.repo.TestRepository;

@RestController
public class TestController {

	@Autowired
	TestRepository repo;

//	@ApiOperation(value = "Create Student", notes = "This method creates a new Student")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved Successfully!", response = String.class) })
	@GetMapping("/createStudent")
	public ResponseEntity<String> testDBOps(Student stud) {
		repo.save(stud);
		return ResponseEntity.status(HttpStatus.OK).body("Saved Successfully!");
	}

}
