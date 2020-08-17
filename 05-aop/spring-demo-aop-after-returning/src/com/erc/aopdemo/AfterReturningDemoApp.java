package com.erc.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.erc.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = accountDAO.findAccounts();
		System.out.println("\n\n Main Program: AfterReturningDemoApp");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();

	}

}
