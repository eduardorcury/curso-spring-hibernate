package com.erc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// todos os métodos no pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	// apenas getters do pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	
	// apenas setters do pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	// excluindo getters e setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
		
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> @Before advice");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====> Doing API analytics...");
	}

}
