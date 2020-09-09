package com.erc.springbootthymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erc.springbootthymeleaf.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		Employee employee1 = new Employee("Eduardo", "Ribeiro", "eduardo@gmail.com");
		Employee employee2 = new Employee("Maria", "Silva", "maria@gmail.com");
		Employee employee3 = new Employee("Daniel", "Souza", "daniel@gmail.com");
		
		employees = new ArrayList<Employee>();
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employees);
		
		return "list-employees";
		
	}

}














