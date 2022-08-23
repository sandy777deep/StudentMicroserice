package com.microservices.project.repository.Student;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.project.pojo.Student.Student;

@Repository
public interface studentRepo extends JpaRepository<Student,Long > {

}
