package springdemo;

public class BaseballCoach implements Coach {
	
	// campo para a dependencia
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "30 minutos de treinamento";
	}

	@Override
	public String getDailyFortune() {
		// usar dependência
		return fortuneService.getFortune();
	}

}
