package com.erc.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.erc.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": ADDING ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doing work");
		return false;
		
	}

}
