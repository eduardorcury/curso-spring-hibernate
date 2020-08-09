package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		
		// carregar arquivo SpringConfiguration
		ClassPathXmlApplicationContext context 
		= new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

		// pegar o Bean do container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());

		// fechar context
		context.close();

	}

}
