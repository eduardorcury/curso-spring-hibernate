# Módulo 1: Spring Core

## Definção de Beans
#### Definição simples

```xml
<bean id="myCoach"
    	class="springdemo.Coach">
</bean>

```

#### Deinição com injeção de argumentos no construtor

```xml
<bean id="myFortune"
    	class="springdemo.HappyFortuneService">
</bean>

<bean id="myCoach"
      class="springdemo.TrackCoach">
  
      <!-- Injeção de construtor -->
      <constructor-arg ref="myFortune" />
</bean>

```

#### Deinição com atributos

```xml
<bean id="myRandomFortune"
      class="springdemo.RandomFortuneService">
 </bean>
    
<bean id="myCricketCoach"
    	class="springdemo.CricketCoach">
    	
    	<!-- injeção setter -->
    	<property name="fortuneService" ref="myRandomFortune"></property>
    	
    	<!-- valores literais -->
    	<property name="emailAddress" value="${email}"></property>
    	<property name="team" value="${team}"></property>
</bean>

```

## Carregando context

```java

public static void main(String[] args) {

  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
}

```

## Pegando Bean do context

```java

public static void main(String[] args) {

  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  
  Coach theCoach = context.getBean("myCoach", Coach.class);
  
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());

	context.close();
  
}

```

## Bean Lifecycle

- init-method: Método chamado ao criar o Bean
- destroy-method: Método chamado ao destruir o Bean

```xml
<bean id="myCoach"
    	class="springdemo.Coach"
    	init-method="create"
    	destroy-method="destroy">
</bean>

```

## Bean Scope
- Singleton: Somente uma instância para todas as requisições
- Prototype: Uma instância é criada a cada requisição

```xml
<bean id="myCoach"
    	class="springdemo.Coach"
    	scope="prototype">
</bean>
