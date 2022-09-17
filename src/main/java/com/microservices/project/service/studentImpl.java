package com.microservices.project.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.microservices.project.pojo.Student.Student;


public interface studentImpl  {
	
	public List<Student> getall();
	
	public Student addStudent(Student s);
	
	public String deleteStudent(Long id );
	
    public Student put(Student s);

    public Student patch(Long id,int standered);
    
    public Student getbyId(Long id);
}

