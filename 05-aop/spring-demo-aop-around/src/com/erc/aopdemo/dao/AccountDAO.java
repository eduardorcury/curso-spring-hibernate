package com.erc.aopdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.erc.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWare) {
		
		if (tripWare) {
			throw new RuntimeException("EXCEÇÃO TESTE");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("Eduardo", "Gold");
		Account account2 = new Account("João", "Silver");
		Account account3 = new Account("Maria", "Platinum");
		myAccounts.addAll(Arrays.asList(account1, account2, account3));
		return myAccounts;
		
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": ADDING ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doing work");
		return false;
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
