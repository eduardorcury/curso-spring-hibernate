package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// carregar arquivo SpringConfiguration
		ClassPathXmlApplicationContext context 
		= new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// pegar o Bean do container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// checar os Beans
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nApontando para o mesmo objeto: " + result);
		System.out.println("\nLocal da memória para theCoach: " + theCoach);
		System.out.println("\nLocal da memória para alphaCoach: " + alphaCoach + "\n");

		// fechar context
		context.close();

	}

}
