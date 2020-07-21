package springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private ArrayList<String> data = new ArrayList<String>();
	private File file = new File("src/sorte.txt");
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.size());
		String theFortune = data.get(index);
		return theFortune;
		
	}
	
	@PostConstruct
	public void addData() throws FileNotFoundException {
		Scanner scanner =  new Scanner(file);
		while (scanner.hasNextLine()) {
			data.add(scanner.nextLine());
		}
		scanner.close();
		System.out.println(data.size());
	}

}
