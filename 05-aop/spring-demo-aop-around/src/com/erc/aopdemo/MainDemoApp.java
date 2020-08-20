package com.erc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.erc.aopdemo.dao.AccountDAO;
import com.erc.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		account.setName("eduardo");
		account.setLevel("admin");
		
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		accountDAO.setName("foo");
		accountDAO.setServiceCode("gold");
		accountDAO.getName();
		accountDAO.getServiceCode();
		
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		
		context.close();

	}

}
