package com.microservices.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.project.pojo.Student.Student;
import com.microservices.project.service.studentImpl;

@RestController
@RequestMapping(value = "/student")

public class StudentController {

	@Autowired
	private studentImpl studentImpl;

	@Value("${spring.application.name: Default Name fetched Sandy's StudentMicroservice}")
	private String ApplicationName;

	

	@GetMapping("/getall")
	public List<Student> getAllStudentDetails() {
		return studentImpl.getall();

	}

	@PostMapping("/add")
	private ResponseEntity<Student> InsertStudent(@Valid @RequestBody Student s) {
		
		Student stuObj=studentImpl.addStudent(s);
		return new ResponseEntity<Student>(stuObj,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> DeleteStudent(@PathVariable Long id) {
		return new ResponseEntity<String>(studentImpl.deleteStudent(id),HttpStatus.OK);

	}

	@PutMapping("/put")
	private ResponseEntity<Student> putStudent( @RequestBody Student s) {
		return new ResponseEntity<Student>(studentImpl.put(s),HttpStatus.OK);

	}

	@PatchMapping("/patch/{id}")
	private ResponseEntity<Student> partialUpdate(@PathVariable Long id, @PathParam(value = "standered") int standered) {
		Student s= studentImpl.patch(id, standered);
        return new ResponseEntity<Student>(s, HttpStatus.ACCEPTED);
	}



	@GetMapping("/AppName")
	private String ApplicationName() {
		System.out.println(ApplicationName);
		return ApplicationName;

	}
	
	@GetMapping("/getOneById/{id}")
	private Student getStudentbyID(@PathVariable Long id) {
		Student sobj= studentImpl.getbyId(id);
	System.out.println(sobj);
	return sobj;
	
	
	}

}
