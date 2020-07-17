package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// carregar arquivo SpringConfiguration
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("applicationContext.xml");

		// pegar o Bean do container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// chamar métodos a partir do Bean
		System.out.println(theCoach.getDailyWorkout());

		// fechar context
		context.close();

	}
	
}
