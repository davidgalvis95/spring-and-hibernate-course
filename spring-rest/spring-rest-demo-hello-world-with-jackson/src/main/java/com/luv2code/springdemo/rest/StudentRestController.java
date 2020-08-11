package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	private List<Student> theStudents;
	// define endpoint for "/students" - return list of students
	
	//The following method allow us to load the data after all the dependencies have been injected
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
			
		return theStudents;
	}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//add some logid to know whether the student is there
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found: " +studentId);
		}
		
		return theStudents.get(studentId);
	}
	
}









