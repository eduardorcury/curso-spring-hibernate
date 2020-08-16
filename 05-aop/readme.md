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
