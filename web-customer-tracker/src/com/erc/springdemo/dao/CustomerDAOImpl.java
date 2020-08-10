package com.erc.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public List<Customer> getCustomers() {

		// pegar sess�o do hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// criar Query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		// executar Query
		List<Customer> customers = query.getResultList();
		
		// retornar lista de objetos
		return customers;
		
	}

}
