package com.erc.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addAccount() {
		
		System.out.println(getClass() + ": ADDING MEMBERSHIP");
		return true;
		
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": going to sleep");
		
	}

}
