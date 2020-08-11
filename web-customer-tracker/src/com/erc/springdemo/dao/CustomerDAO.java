package com.erc.springdemo.dao;

import java.util.List;

import com.erc.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
