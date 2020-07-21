package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	// Contrutor padrão
	public TennisCoach() {
		System.out.println("Dentro do construtor");
	}
	
	// m�todo ao iniciar o Bean
	@PostConstruct
	public void iniciar() {
		System.out.println("Criando Bean");
	}
	
	// m�todo ao destruir o bean
	@PreDestroy
	public void destruir() {
		System.out.println("Destruindo Bean");
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
		return "Praticar t�nis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
