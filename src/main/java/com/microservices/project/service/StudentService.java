package com.microservices.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.project.exceptions.EmptyInputException;
import com.microservices.project.exceptions.ResourceNotfoundException;
import com.microservices.project.pojo.Student.Student;
import com.microservices.project.repository.Student.studentRepo;

@Service
public class StudentService implements studentImpl {

	@Autowired
	private  studentRepo studentRepo;
  
	public java.util.List<Student> getall() {
		List<Student> S = studentRepo.findAll();
		if (S.isEmpty()) {
			throw new ResourceNotfoundException("No students are present in Data Base");
		}

		return S;
	}

	public Student addStudent(Student s) {
		
		if (s.getStudentName().equalsIgnoreCase("") || s.getDateOfBirth() == null
				|| (s.getStandered() < 0 || s.getStandered() > 12)) {
			throw new EmptyInputException("Please input the data correctly");
		}	
		List<Student> S = studentRepo.findAll();
		for(Student sObj:S) {
			if(s.getStudentName().equalsIgnoreCase(sObj.getStudentName())) {
				throw new RuntimeException("Student with same name already present");
			}
		}
			
		
		return studentRepo.save(s);

	}

	public String deleteStudent(Long id) {
		Optional<Student> sObj = studentRepo.findById(id);
		if (!sObj.isPresent()) {
			throw new ResourceNotfoundException("Student is not present in DataBase");
		}

		studentRepo.deleteById(id);
		return "Deleted successfully";
	}

	public Student put(Student s) {
		studentRepo.save(s);
		return s;
	}

	public Student patch(Long id, int standered) {
		Optional<Student> sObj = studentRepo.findById(id);
		if (!sObj.isPresent()) {
			throw new ResourceNotfoundException("Student is not present in DataBase");
		}
		Student s = studentRepo.getById(id);
		s.setStandered(standered);
		studentRepo.save(s);
		return s;
	}

	@Override
	public Student getbyId(Long id) {
		
		return studentRepo.getOne(id);
	}

}
