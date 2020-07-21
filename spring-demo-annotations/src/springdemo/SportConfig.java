package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
	
	// Bean para fortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Bean para swimCoach e injetar dependência
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
