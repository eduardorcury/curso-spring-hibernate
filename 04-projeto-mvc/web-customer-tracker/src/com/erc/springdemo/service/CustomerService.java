package com.erc.springdemo.service;

import java.util.List;

import com.erc.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(Integer id);

	public void deleteCustomer(Integer id);

}
