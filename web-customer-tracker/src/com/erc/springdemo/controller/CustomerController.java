package com.erc.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erc.springdemo.entity.Customer;
import com.erc.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// spring seleciona a classe que implementa a interface
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// retornando do Service
		List<Customer> customers = customerService.getCustomers();
		
		// adicionar objetos ao model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}

}








