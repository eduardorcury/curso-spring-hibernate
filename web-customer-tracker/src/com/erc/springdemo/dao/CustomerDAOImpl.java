package com.erc.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erc.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// pegar sessão do hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// criar Query
		Query<Customer> query = session.createQuery("from Customer order by lastName", 
													Customer.class);
		
		// executar Query
		List<Customer> customers = query.getResultList();
		
		// retornar lista de objetos
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
		
	}

}
