package com.erc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// todos os métodos no pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	// apenas getters do pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	// apenas setters do pacote dao
	@Pointcut("execution(* com.erc.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	// excluindo getters e setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}

}
