package springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// construtor sem argumentos
	public CricketCoach() {
		System.out.println("CricketCoach: dentro do construtor sem argumentos");
	}
	
	// método set chamado pelo Spring Framework
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: dentro do método set");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Praticar por 30 minutos";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
