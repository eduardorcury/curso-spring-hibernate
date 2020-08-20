package com.erc.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.erc.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {

			myLogger.warning(e.getMessage());
			
			throw e;
			
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\nDuração: " + duration/1000 + " segundos");
		
		return result;
		
	}
	
	@After("execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinnalyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @After (finally) on method: " + method);
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterThrowing on method: " + method);
		
		myLogger.info("\n======> The exception is: " + theExc);
		
	}
	
	@AfterReturning(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterReturning on method: " + method);
		
		myLogger.info("\n======> Result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n======> Result in UpperCase is: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
		
	}

	@Before("com.erc.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====> @Before advice");
		
		// mostrando assinatura do método
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Método: " + methodSig);
		
		// mostrando argumentos do método
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}
		}
	}
}
