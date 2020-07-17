package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// carregar arquivo SpringConfiguration
		ClassPathXmlApplicationContext context 
				= new ClassPathXmlApplicationContext("applicationContext.xml");

		// pegar o Bean do container
		Coach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// chamar métodos a partir do Bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// fechar context
		context.close();

	}

}
