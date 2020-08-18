package com.erc.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.erc.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			boolean tripWare = true;
			theAccounts = accountDAO.findAccounts(tripWare);
		}
		catch(Exception exc) {
			System.out.println("\n\nExceção: " + exc);
		}
		
		
		System.out.println("\n\n Main Program: AfterThrowingDemoApp");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();

	}

}
