package springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {"Sorte 1",
								"Sorte 2",
								"Sorte 3"};

	@Override
	public String getFortune() {
		
		Random random = new Random();
		return fortunes[random.nextInt(3)];
		
	}

}
