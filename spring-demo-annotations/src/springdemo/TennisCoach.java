package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	// Contrutor padrão
	public TennisCoach() {
		System.out.println("Dentro do construtor");
	}
	
	/* 
	Injeção por método aleatório
	@Autowired
	public void metodoAleatorio(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Dentro do método setter");
	}
	
	Injeção por construtor
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Praticar tênis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
