package springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Nade no oceano atlântico";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
