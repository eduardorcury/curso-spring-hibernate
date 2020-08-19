package com.erc.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.erc.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinnalyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @After (finally) on method: " + method);
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n======> The exception is: " + theExc);
		
	}
	
	@AfterReturning(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n======> Result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n======> Result in UpperCase is: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
		
	}

	@Before("com.erc.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====> @Before advice");
		
		// mostrando assinatura do método
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Método: " + methodSig);
		
		// mostrando argumentos do método
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	}
}
