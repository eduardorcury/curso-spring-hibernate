package com.erc.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.cruddemo.dao.EmployeeDao;
import com.erc.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDao employeeDAO;
	
	@Autowired
	public EmployeeRestController(EmployeeDao theEmployeeDao) {
		employeeDAO = theEmployeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}

























