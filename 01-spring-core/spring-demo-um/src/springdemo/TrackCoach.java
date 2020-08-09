package springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Corra 5 km";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it:" + fortuneService.getFortune();
	}
	
	// método ao criar Bean
	public void create() {
		System.out.println("TrackCoach Bean criado");
	}
	
	// método ao destruir Bean
	public void destroy() {
		System.out.println("TrackCoach Bean destruído");
	}

}
