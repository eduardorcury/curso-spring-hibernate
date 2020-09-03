package com.erc.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Eduardo", "Ribeiro"));
		students.add(new Student("Maria", "Silva"));
		students.add(new Student("Daniel", "Magalhães"));
		
		return students;
		
	}

}
