# Módulo 4: Aspect Oriented Programming (AOP)

## @Before
Executa um advice antes do método da anotação.

#### Pointcut Expressions

Anotação apenas para os métodos *public void addAccount()*:

```java
@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(public void addAccount()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> @Before advice");
	}
}
```
Anotação para todos os métodos do pacote com.erc.aopdemo.dao:

```java
@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(* com.erc.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> @Before advice");
	}
}
```
> Símbolo * significa qualquer (com qualquer retorno, em qualquer classe e com qualquer nome).

> (..) siginifica com qualquer parâmetro (um ou mais de qualquer tipo).

#### Pointcut Declarations

Combinando expressions para excluir getters e setters:

```java
// todos os métodos no pacote dao
@Pointcut("execution(* com.erc.aopdemo.dao.*.*(..))")
private void forDaoPackage() { }
	
// apenas getters do pacote dao
@Pointcut("execution(* com.erc.aopdemo.dao.*.get*(..))")
private void getter() { }
	
// apenas setters do pacote dao
@Pointcut("execution(* com.erc.aopdemo.dao.*.set*(..))")
private void setter() {	}
	
// excluindo getters e setters
@Pointcut("forDaoPackage() && !(getter() || setter())")
private void forDaoPackageNoGetterSetter() { }
	
@Before("forDaoPackageNoGetterSetter()")
public void beforeAddAccountAdvice() {
	System.out.println("\n=====> @Before advice");
}
```

#### JoinPointers

Permitem acessar dados do método (parâmetros e assinatura)

```java
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
```

## @AfterReturning

Advice executado depois que o método retorna um valor.

```java
@AfterReturning(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
	...
	// retorno: lista result
}
```

## @AfterReturning

Advice executado se o método lançar uma exceção.
```java
@AfterThrowing(pointcut = "execution(* com.erc.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
	...
	// exceção: theExc
}
```