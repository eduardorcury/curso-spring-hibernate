package com.erc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.erc.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount();
		
		accountDAO.addAccount();
		
		context.close();

	}

}
