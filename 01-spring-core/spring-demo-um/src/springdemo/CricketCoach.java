package springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// novos campos
	private String emailAddress;
	private String team;
	
	// construtor sem argumentos
	public CricketCoach() {
		System.out.println("CricketCoach: dentro do construtor sem argumentos");
	}
	
	// método set chamado pelo Spring Framework
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: dentro do método set");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: dentro do método setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: dentro do método setTeam");
		this.team = team;
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
