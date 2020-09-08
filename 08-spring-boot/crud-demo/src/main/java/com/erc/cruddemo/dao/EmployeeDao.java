package com.erc.cruddemo.dao;

import java.util.List;

import com.erc.cruddemo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();

}
